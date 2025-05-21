package CanvasApp.View.ShapeView.Decorator.Text;

import CanvasApp.Model.Structure.HasText;
import CanvasApp.View.ShapeView.Decorator.ShapeViewDecorator;
import CanvasApp.View.ShapeView.ShapeView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ShapeCmd.Decorate.UpdateTextCmd;
import CanvasApp.ViewModel.Data.ShapeData.Decorator.Text.TextInShapeData;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.*;

public class TextInShapeView extends ShapeViewDecorator implements HasText {
    private final JTextField textEditField;
    private final TextInShapeData textInShapeData;

    public TextInShapeView(TextInShapeData shapeData, CanvasVM viewModel, ShapeView decorated) {
        super(shapeData, viewModel, decorated);
        this.textInShapeData = shapeData;
        this.shapeDataEventHandler = new TextInShapeViewHandler(this);
        this.shapeData.attach(this.shapeDataEventHandler);

        this.textEditField = new JTextField(shapeData.getText());
        this.textEditField.setHorizontalAlignment(JTextField.CENTER);
        this.textEditField.setOpaque(false);
        this.add(textEditField);
        this.setBackground(Color.YELLOW);

        setupField(textEditField, this::commitEdit);
    }

    private void setupField(JTextField field, Runnable commit) {
        field.addActionListener(e -> commit.run());
        field.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                commit.run();
            }
        });

        field.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { updateTextFieldBounds(); }
            @Override public void removeUpdate(DocumentEvent e) { updateTextFieldBounds(); }
            @Override public void changedUpdate(DocumentEvent e) { updateTextFieldBounds(); }
        });
    }

    private void commitEdit() {
        String newText = textEditField.getText();
        if (!newText.equals(textInShapeData.getText())) {
            System.out.println("[commitEdit] newText : " + newText);
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
    }

    public void updateTextDisplay(String text) {
        textEditField.setText(text);
        System.out.println("[updateTextDisplay] currentText : " + textEditField.getText());
        updateTextFieldBounds();
        repaint();
    }

    @Override
    public String getText() {
        return textInShapeData.getText();
    }

    @Override
    public void setText(String text) {
        updateTextDisplay(text);
    }
}
