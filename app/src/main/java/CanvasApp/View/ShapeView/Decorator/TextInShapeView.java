package CanvasApp.View.ShapeView.Decorator;

import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ShapeCmd.UpdateTextCmd;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeData;
import CanvasApp.ViewModel.Data.ShapeData.ShapeData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class TextInShapeView extends ShapeDecoratorView {
    private String text;
    private final JTextField textEditField;
    // TextInShapeData에 접근할 수 있도록 protected 또는 getter 추가
    protected final TextInShapeData textInShapeData; // 핸들러 인스턴스

    public TextInShapeView(TextInShapeData shapeData, CanvasVM viewModel, ShapeView decorated) {
        super(shapeData, viewModel, decorated);
        this.textInShapeData = shapeData;
        this.text = shapeData.getText();
        this.shapeDataEventHandler = new TextInViewHandler(this);
        this.textInShapeData.attach(this.shapeDataEventHandler);
        System.out.println("TextInShapeView - constructor called");

        if (decorated == null) {
            throw new IllegalArgumentException("Decorated ShapeView must be a JComponent.");
        }

        setLayout(new BorderLayout());

        this.textEditField = new JTextField();
        this.textEditField.setVisible(false);
        this.textEditField.setHorizontalAlignment(JTextField.CENTER);
        this.add(textEditField);
        this.setOpaque(false);

        setupMouseListener();
        setupTextFieldListeners();
    }

    private void setupMouseListener() {
        this.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // decorated가 보이고, 편집 필드가 안 보일 때 더블클릭하면 편집 시작
                if (e.getClickCount() == 2 && decorated.isVisible() && !textEditField.isVisible()) {
                    startEditing();
                } else if (textEditField.isVisible() && !textEditField.getBounds().contains(e.getPoint())) {
                    // 편집 중인데 텍스트 필드 바깥을 클릭하면 편집 종료
                     stopEditing();
                }
            }
        });
    }

    private void startEditing() {
        this.text = textInShapeData.getText();
        textEditField.setText(this.text);

        int padding = Math.min(10, Math.min(getWidth(), getHeight()) / 5);
        int fieldWidth = Math.max(50, getWidth() - 2 * padding); // 최소 너비 보장
        int fieldHeight = textEditField.getPreferredSize().height;
        int fieldX = (getWidth() - fieldWidth) / 2;
        int fieldY = (getHeight() - fieldHeight) / 2;

        textEditField.setBounds(fieldX, fieldY, fieldWidth, fieldHeight);
        textEditField.setVisible(true);
        textEditField.requestFocusInWindow();
        repaint();
    }

    private void stopEditing() {
        if (!textEditField.isVisible()) return; // 이미 종료된 경우

        String newText = textEditField.getText();
        textEditField.setVisible(false);
        decorated.setVisible(true);

//        if (commitChange) {
            if (!newText.equals(this.textInShapeData.getText())) {
                viewModel.handleCmd(new UpdateTextCmd(viewModel, shapeData.getId(), newText));
            }
//        }
//        this.text = textInShapeData.getText();
//        repaint();
    }

    public ShapeData getShapeData(){
        return shapeData;
    }

    private void setupTextFieldListeners() {
        textEditField.addActionListener(e -> stopEditing()); // Enter 키

        textEditField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                // 포커스를 잃으면 변경사항 커밋
                // GlassPane 등으로 화면 전체를 덮는게 아니라면, 다른 컴포넌트 클릭 시 focusLost 발생
                stopEditing();
            }
        });
    }

    // TextInViewHandler에 의해 호출되어 외부에서 텍스트 변경 시 화면 갱신
    public void updateTextDisplay(String newText) {
        this.text = newText;
        if (!textEditField.isVisible()) { // 편집 중이 아닐 때만 repaint
            repaint();
        }
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);

        // 편집 중이 아니고, decorated가 보이고, 텍스트가 있을 때만 텍스트 오버레이를 그림
        if (!textEditField.isVisible() && decorated.isVisible() && this.text != null && !this.text.isEmpty()) {
            drawTextOverlay(g);
        }
    }

    private void drawTextOverlay(Graphics g) {
        Graphics2D g2d = (Graphics2D) g.create();
        // 안티앨리어싱 설정
        g2d.setRenderingHint(RenderingHints.KEY_TEXT_ANTIALIASING, RenderingHints.VALUE_TEXT_ANTIALIAS_ON);
        g2d.setRenderingHint(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);

        // 폰트 설정 (기본 폰트 또는 컴포넌트 폰트)
        Font font = getFont();
        if (font == null) {
            font = new Font("SansSerif", Font.PLAIN, 10);
        }
        g2d.setFont(font);

        FontMetrics fm = g2d.getFontMetrics();
        int stringWidth = fm.stringWidth(this.text);

        // 텍스트 중앙 정렬
        int x = (getWidth() - stringWidth) / 2;
        int y = (getHeight() - fm.getHeight()) / 2 + fm.getAscent();

        g2d.setColor(Color.BLACK); // 텍스트 색상
        g2d.drawString(this.text, x, y);
        g2d.dispose();
    }

    @Override
    public void draw(Graphics g) {
        // All drawing is handled by paintComponent and child components
    }
}