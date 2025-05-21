package CanvasApp.ViewModel.Command.ShapeCmd.Decorate;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class UpdateTextCmd implements Command {
    CanvasVM viewModel;
    String newText;
    String id;

    public UpdateTextCmd(CanvasVM viewModel, String id, String newText) {
        this.viewModel = viewModel;
        this.id = id;
        this.newText = newText;
    }

    @Override
    public void execute() {
        System.out.println("[UpdateTextCmd] newText : " + newText);
        viewModel.changeText(id, newText);
    }
}
