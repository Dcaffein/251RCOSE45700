package CanvasApp.View.ToolView;

import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ToolCmd.SetTempRectCreateCmd;

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

        selectBtn.addActionListener(e ->
                viewModel.handleCmd(new SetTempRectCreateCmd(viewModel)));
        rectBtn.addActionListener(e ->
                viewModel.handleCmd(new SetTempRectCreateCmd(viewModel)));
//        ellipseBtn.addActionListener(e ->
//                viewModel.handleCmd(new SetTempRectCreateCmd(viewModel)));

        this.add(selectBtn);
        this.add(rectBtn);
        this.add(ellipseBtn);
    }
}
