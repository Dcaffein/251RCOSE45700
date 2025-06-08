package CanvasApp.View.ToolView;

import CanvasApp.Factory.ShapeFactory.*;
import CanvasApp.ViewModel.SelectionManager.SelectionManager;
import CanvasApp.ViewModel.StateManager.Cmd.SetCommonState;
import CanvasApp.ViewModel.StateManager.State.StateForCreate;
import CanvasApp.ViewModel.StateManager.State.StateForSelect;
import CanvasApp.ViewModel.StateManager.StateManager;
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
//        JButton addTextBtn = new JButton("Add Text");
//        JButton addShadowBtn = new JButton("Add Shadow");

        StateManager stateManager = viewModel.stateManager;
        SelectionManager selectionManager = viewModel.selectionManager;
        selectBtn.addActionListener(e -> (new SetCommonState(stateManager,new StateForSelect())).execute());
        rectBtn.addActionListener(e ->{
                selectionManager.deselectAll();
                (new SetCommonState(stateManager,
                        new StateForCreate(RectFactory.getInstance().createShapeModel(0,0,0,0,0)))).execute();});
        ellipseBtn.addActionListener(e -> (
                new SetCommonState(stateManager,
                        new StateForCreate(EllipseFactory.getInstance().createShapeModel(0,0,0,0,0)))).execute());
        triangleBtn.addActionListener(e -> (
                new SetCommonState(stateManager,
                        new StateForCreate(TriangleFactory.getInstance().createShapeModel(0,0,0,0,0)))).execute());
        lineBackSlashBtn.addActionListener(e -> (
                new SetCommonState(stateManager,
                        new StateForCreate(LineBackSlashFactory.getInstance().createShapeModel(0,0,0,0,0)))).execute());
        lineSlashBtn.addActionListener(e -> (
                new SetCommonState(stateManager,
                        new StateForCreate(LineSlashFactory.getInstance().createShapeModel(0,0,0,0,0)))).execute());
//        imageBtn.addActionListener(e -> (
//                new SetCommonState(stateManager,
//                        new StateForCreate(ImageFactory.getInstance().createShapeModel(0,0,0,0,0)))).execute());

        //        textBtn.addActionListener(e -> (new SetCommonState(stateManager,new StateForSelect())).execute());
//        addTextBtn.addActionListener(e -> {
//            (new DecorateWithTextCmd(viewModel, "text"));
//        });
//        addShadowBtn.addActionListener(
//                e -> (new DecorateWithShadowCmd(viewModel, new Color(0, 0, 0, 80), 3)));

        this.add(selectBtn);
        this.add(rectBtn);
        this.add(ellipseBtn);
        this.add(triangleBtn);
        this.add(lineBackSlashBtn);
        this.add(lineSlashBtn);
//        this.add(imageBtn);
//        this.add(textBtn);
//        this.add(addTextBtn);
//        this.add(addShadowBtn);
    }
}
