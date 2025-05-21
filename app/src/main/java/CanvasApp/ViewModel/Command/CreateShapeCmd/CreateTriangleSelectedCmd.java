package CanvasApp.ViewModel.Command.CreateShapeCmd;

import CanvasApp.Factory.TriangleFactory;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CreateTriangleSelectedCmd implements Command {
  private final CanvasVM canvasVM;

  public CreateTriangleSelectedCmd(CanvasVM canvasVM) {
    this.canvasVM = canvasVM;
  }

  @Override
  public void execute() {
    System.out.println("[ToolCmd] CreateTriangleFactory executed");
    canvasVM.setCurrentFactory(TriangleFactory.getInstance());
    canvasVM.setCanvasDraggable(true);
  }
}