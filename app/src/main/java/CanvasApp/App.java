package CanvasApp;

import CanvasApp.View.CanvasView.CanvasView;
import CanvasApp.View.ToolView.ToolBarView;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Data.CanvasData.CanvasData;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Canvas App");
        CanvasData canvasData = new CanvasData();
        CanvasVM viewModel = new CanvasVM(canvasData);
        CanvasView canvasView = new CanvasView(viewModel, canvasData);
        ToolBarView toolBarView = new ToolBarView(viewModel);

        // 메인 패널 구성
        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(toolBarView, BorderLayout.WEST);   // 도구 모음 왼쪽
        mainPanel.add(canvasView, BorderLayout.CENTER);  // 캔버스 중앙

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);  // 메인 패널을 프레임에 설정
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }
}