package CanvasApp;

import CanvasApp.Model.Composite.ShapeModelGroup;
import CanvasApp.Model.ShapeModel;
import CanvasApp.View.CanvasView.CanvasView;
import CanvasApp.View.PropertyView.PropertyView;
import CanvasApp.View.ToolView.ToolBarView;
import CanvasApp.ViewModel.CanvasViewModel.CanvasViewModel;
import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;

import javax.swing.*;
import java.awt.*;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Canvas App");
        ShapeModel canvas = new ShapeModelGroup();
        SelectionManager.init(canvas);
        CanvasView canvasView = new CanvasView(new CanvasViewModel(canvas));
        ToolBarView toolBarView = new ToolBarView(new ToolViewModel(canvas));
        PropertyView propertyView = new PropertyView(new PropertyViewModel());

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.add(toolBarView, BorderLayout.WEST);
        mainPanel.add(canvasView, BorderLayout.CENTER);
        mainPanel.add(propertyView, BorderLayout.EAST);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setContentPane(mainPanel);
        frame.setSize(1000, 600);
        frame.setVisible(true);
    }
}