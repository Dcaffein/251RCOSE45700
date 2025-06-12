package CanvasApp.View.ShapeView;

import CanvasApp.View.ShapeView.Drawer.Drawer;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.event.*;

public class TextView extends ShapeView {

    private final JTextField textField;
    private boolean isEditing = false;

    public TextView(ShapeViewModel viewModel, Drawer drawer) {
        super(viewModel, drawer);

        // 1. 텍스트 편집을 위한 JTextField 생성 및 설정
        this.textField = new JTextField("기본 텍스트"); // 기본값 설정
        this.textField.setBounds(0, 0, 100, 30); // 위치와 크기 설정
        this.textField.setVisible(true); // 일단 항상 보이게

        // 2. 편집 완료 이벤트 처리
        this.textField.addActionListener(e -> stopEditing());
        this.textField.addFocusListener(new FocusAdapter() {
            @Override
            public void focusLost(FocusEvent e) {
                stopEditing();
            }
        });

        this.textField.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                // 더블클릭 시 그리고 아직 편집 중이 아닐 때만 편집 모드 시작
                if (e.getClickCount() == 2 && !isEditing) {
                    startEditing();
                }
            }
        });
    }


    private void startEditing() {
        isEditing = true;

        textField.setBounds(0, 0, getWidth(), getHeight());

        // 현재 모델의 텍스트를 textField에 설정
//        textField.setText(viewModel.getShape().getText());
        textField.setVisible(true);
        textField.requestFocus();

        repaint();
    }

    private void stopEditing() {
        if (!isEditing) return;
        isEditing = false;

        String newText = textField.getText();
//        (new SetTextCommand(viewModel, newText)).execute();

        textField.setVisible(false);
        repaint();
    }

    public boolean isEditing() {
        return isEditing;
    }
}