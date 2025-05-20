package CanvasApp.View.ShapeView.Decorator;

import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ShapeCmd.UpdateTextCmd;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.TextInShapeData;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class TextInShapeView extends ShapeDecoratorView {
    private final JTextField textEditField;
    private final TextInShapeData textInShapeData;

    public TextInShapeView(TextInShapeData shapeData, CanvasVM viewModel, ShapeView decorated) {
        super(shapeData, viewModel, decorated);
        setLayout(null);
        this.textInShapeData = shapeData;
        this.shapeDataEventHandler = new TextInViewHandler(this);
        this.textInShapeData.attach(this.shapeDataEventHandler);

        this.textEditField = new JTextField(shapeData.getText());
        this.textEditField.setHorizontalAlignment(JTextField.CENTER);
        this.add(textEditField);
        this.setBackground(Color.YELLOW);

        setupField(textEditField, this::commitEdit);
    }

    private void setupField(JTextField field, Runnable commit) {
        // 엔터 입력 또는 포커스 잃을 때 커밋
        field.addActionListener(e -> commit.run());
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                commit.run();
            }
        });

        // 텍스트 변경될 때마다 필드 크기 갱신
        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { updateTextFieldBounds(); }
            @Override public void removeUpdate(DocumentEvent e) { updateTextFieldBounds(); }
            @Override public void changedUpdate(DocumentEvent e) { updateTextFieldBounds(); }
        });
    }

    private void commitEdit() {
        String newText = textEditField.getText();
        if (!newText.equals(textInShapeData.getText())) {
            viewModel.handleCmd(new UpdateTextCmd(viewModel, shapeData.getId(), newText));
        }
    }

    @Override
    public void draw(Graphics g) {}

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
    }

    @Override
    public void setBounds(int x, int y, int width, int height) {
        super.setBounds(x, y, width, height);
        SwingUtilities.invokeLater(this::updateTextFieldBounds);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        SwingUtilities.invokeLater(this::updateTextFieldBounds);
    }

    private void updateTextFieldBounds() {
        String text = textEditField.getText();
        if (text == null || text.isEmpty()) {
            text = " ";
        }

        Font font = getFont();
        if (font == null) font = new Font("SansSerif", Font.PLAIN, 12);
        textEditField.setFont(font);

        FontMetrics fm = getFontMetrics(font);

        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        int horizontalPadding = 10;
        int verticalPadding = 4;

        int minWidth = 50;
        int minHeight = 24;
        int maxWidth = Math.max(getWidth() - 4, minWidth);
        int maxHeight = Math.max(getHeight() - 4, minHeight);

        int fieldWidth = Math.min(textWidth + 2 * horizontalPadding, maxWidth);
        int fieldHeight = Math.min(textHeight + verticalPadding, maxHeight);

        int x = (getWidth() - fieldWidth) / 2;
        int y = (getHeight() - fieldHeight) / 2;

        textEditField.setBounds(x, y, fieldWidth, fieldHeight);

        System.out.println("[updateTextFieldBounds] : " + textEditField.getBounds());
        System.out.println("[TextInShapeView] : " + this.getBounds());
    }
}
