package CanvasApp.View.ToolView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CreateEllipseSelectedCmd;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CreateImageSelectedCmd;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CreateLineBackSlashSelectedCmd;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CreateRectSelectedCmd;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CreateTextSelectedCmd;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CreateTriangleSelectedCmd;
import CanvasApp.ViewModel.Command.CreateShapeCmd.CreateLineSlashSelectedCmd;
import CanvasApp.ViewModel.Command.SelectToolSelectedCmd;
import CanvasApp.ViewModel.Command.ShapeCmd.Decorate.DecorateWithShadowCmd;
import CanvasApp.ViewModel.Command.ShapeCmd.Decorate.DecorateWithTextCmd;

import javax.swing.*;
import java.awt.*;

public class ToolBarView extends JPanel {
    private final CanvasVM viewModel;

    public ToolBarView(CanvasVM viewModel) {
        this.viewModel = viewModel;
        setLayout(new GridLayout(0, 1, 5, 5));
        setPreferredSize(new Dimension(100, 600));

        init();
    }

    private void init() {
        JButton selectBtn = new JButton("Select");
        JButton rectBtn = new JButton("Rect");
        JButton ellipseBtn = new JButton("Ellipse");
        JButton triangleBtn = new JButton("Triangle");
        JButton imageBtn = new JButton("Image");
        JButton lineBackSlashBtn = new JButton("Line \\");
        JButton lineSlashBtn = new JButton("Line /");
        JButton textBtn = new JButton("Text");
        JButton addTextBtn = new JButton("Add Text");
        JButton addShadowBtn = new JButton("Add Shadow");

        selectBtn.addActionListener(e -> viewModel.handleCmd(new SelectToolSelectedCmd(viewModel)));
        rectBtn.addActionListener(e -> viewModel.handleCmd(new CreateRectSelectedCmd(viewModel)));
        ellipseBtn.addActionListener(e -> viewModel.handleCmd(new CreateEllipseSelectedCmd(viewModel)));
        triangleBtn.addActionListener(e -> viewModel.handleCmd(new CreateTriangleSelectedCmd(viewModel)));
        imageBtn.addActionListener(e -> viewModel.handleCmd(new CreateImageSelectedCmd(viewModel)));
        lineBackSlashBtn.addActionListener(e -> viewModel.handleCmd(new CreateLineBackSlashSelectedCmd(viewModel)));
        lineSlashBtn.addActionListener(e -> viewModel.handleCmd(new CreateLineSlashSelectedCmd(viewModel)));
        textBtn.addActionListener(e -> viewModel.handleCmd(new CreateTextSelectedCmd(viewModel)));
        addTextBtn.addActionListener(e -> {
            viewModel.handleCmd(new DecorateWithTextCmd(viewModel, "text"));
        });
        addShadowBtn.addActionListener(
                e -> viewModel.handleCmd(new DecorateWithShadowCmd(viewModel, new Color(0, 0, 0, 80), 3)));

        this.add(selectBtn);
        this.add(rectBtn);
        this.add(ellipseBtn);
        this.add(triangleBtn);
        this.add(imageBtn);
        this.add(lineBackSlashBtn);
        this.add(lineSlashBtn);
        this.add(textBtn);
        this.add(addTextBtn);
        this.add(addShadowBtn);
    }
}
