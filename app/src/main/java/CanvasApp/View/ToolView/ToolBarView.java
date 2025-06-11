package CanvasApp.View.ToolView;

import CanvasApp.ViewModel.ToolViewModel.Cmd.*;
import CanvasApp.ViewModel.ToolViewModel.ToolViewModel;

import javax.swing.*;
import java.awt.*;

public class ToolBarView extends JPanel {
    private final ToolViewModel viewModel;

    public ToolBarView(ToolViewModel viewModel) {
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
        JButton lineBackSlashBtn = new JButton("Line \\");
        JButton lineSlashBtn = new JButton("Line /");

//        JButton imageBtn = new JButton("Image");
//        JButton textBtn = new JButton("Text");
        JButton applyTextBtn = new JButton("Apply Text");
        JButton applyShadowBtn = new JButton("Apply Shadow");

        selectBtn.addActionListener(e -> new ReadyToSelect(viewModel).execute());
        rectBtn.addActionListener(e -> new CreateRect(viewModel).execute());
        ellipseBtn.addActionListener(e -> new CreateEllipse(viewModel).execute());
        triangleBtn.addActionListener(e -> new CreateTriangle(viewModel).execute());
        lineBackSlashBtn.addActionListener(e -> new CreateLineBackSlash(viewModel).execute());
        lineSlashBtn.addActionListener(e -> new CreateLineSlash(viewModel).execute());
//        imageBtn.addActionListener(e -> (
//                new SetCommonState(stateManager,
//                        new StateForCreate(ImageFactory.getInstance().createShapeModel(0,0,0,0,0)))).execute());

        //        textBtn.addActionListener(e -> (new SetCommonState(stateManager,new StateForSelect())).execute());
        applyTextBtn.addActionListener(e -> new ToggleInnerText(viewModel).execute());
        applyShadowBtn.addActionListener(
                e ->  new ToggleShadow(viewModel).execute());

        this.add(selectBtn);
        this.add(rectBtn);
        this.add(ellipseBtn);
        this.add(triangleBtn);
        this.add(lineBackSlashBtn);
        this.add(lineSlashBtn);
//        this.add(imageBtn);
//        this.add(textBtn);
        this.add(applyTextBtn);
        this.add(applyShadowBtn);
    }
}
