package CanvasApp.ViewModel.Command.ShapeCmd.Decorate;

import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class DecorateWithTextCmd implements Command {
    private final CanvasVM viewModel;
    private final String text;

    public DecorateWithTextCmd(CanvasVM viewModel, String text) {
        this.viewModel = viewModel;
        this.text = text;
    }

    @Override
    public void execute() {
        viewModel.decoratesWithText(text);
        System.out.println("[DecorateWithTextCmd] text : " + text);
    }
}