package CanvasApp.View.ShapeView;

import CanvasApp.Model.Structure.HasText;
import CanvasApp.View.ShapeView.EventHandler.ShapeDataEventHandler;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ShapeCmd.Decorate.UpdateTextCmd;
import CanvasApp.ViewModel.Data.ShapeData.TextShapeData;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class TextView extends ConcreteShapeView implements HasText {
    private TextShapeData textData;
    private final JTextField textField;

    public TextView(TextShapeData shapeData, CanvasVM viewModel) {
        super(shapeData, viewModel);
        textData = shapeData;
        this.shapeDataEventHandler = new ShapeDataEventHandler(this);
        shapeData.attach(shapeDataEventHandler);

        this.textField = new JTextField(textData.getText());
        this.textField.setHorizontalAlignment(JTextField.CENTER);
        this.textField.setOpaque(false);
        this.textField.setBorder(null);
        this.setLayout(null);
        this.add(textField);

        setupListeners();
    }

    private void updateTextFieldBounds() {
        String text = textField.getText();
        if (text == null || text.isEmpty()) text = " ";

        Font font = getFont();
        if (font == null) font = new Font("SansSerif", Font.PLAIN, 12);
        textField.setFont(font);
        FontMetrics fm = getFontMetrics(font);

        int textWidth = fm.stringWidth(text);
        int textHeight = fm.getHeight();

        int fieldWidth = Math.min(textWidth + 20, getWidth() - 4);
        int fieldHeight = Math.min(textHeight + 8, getHeight() - 4);

        int x = (getWidth() - fieldWidth) / 2;
        int y = (getHeight() - fieldHeight) / 2;

        textField.setBounds(x, y, fieldWidth, fieldHeight);
    }

    @Override
    public void addNotify() {
        super.addNotify();
        SwingUtilities.invokeLater(this::updateTextFieldBounds);
    }

    @Override
    public void setBounds(int x, int y, int w, int h) {
        super.setBounds(x, y, w, h);
        SwingUtilities.invokeLater(this::updateTextFieldBounds);
    }

    private void setupListeners() {
        textField.addActionListener(e -> commitEdit());
        textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                commitEdit();
            }
        });
        textField.getDocument().addDocumentListener(new DocumentListener() {
            @Override public void insertUpdate(DocumentEvent e) { updateTextFieldBounds(); }
            @Override public void removeUpdate(DocumentEvent e) { updateTextFieldBounds(); }
            @Override public void changedUpdate(DocumentEvent e) { updateTextFieldBounds(); }
        });
    }

    private void commitEdit() {
        String newText = textField.getText();
        if (!newText.equals(textData.getText())) {
            System.out.println("[TextView] commitEdit : " + newText);
            viewModel.handleCmd(new UpdateTextCmd(viewModel, textData.getId(), newText));
        }
    }

    public void updateTextDisplay(String text) {
        textField.setText(text);
        System.out.println("[updateTextDisplay] currentText : " + textField.getText());
        updateTextFieldBounds();
        repaint();
    }

    @Override
    public void draw(Graphics g) {

    }

    @Override
    public Shape getShape() {
        return new Rectangle(0, 0, getWidth(), getHeight());
    }

    @Override
    public String getText() {
        return textData.getText();
    }

    @Override
    public void setText(String text) {
        updateTextDisplay(text);
        System.out.println("[TextView] text : " + text);
    }
}
