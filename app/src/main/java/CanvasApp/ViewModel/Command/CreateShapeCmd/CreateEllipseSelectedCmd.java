package CanvasApp.ViewModel.Command.CreateShapeCmd;

import CanvasApp.Factory.EllipseFactory;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

public class CreateEllipseSelectedCmd implements Command {
  private final CanvasVM canvasVM;

  public CreateEllipseSelectedCmd(CanvasVM canvasVM) {
    this.canvasVM = canvasVM;
  }

  @Override
  public void execute() {
    System.out.println("[ToolCmd] CreateEllipseSelectedCmd executed");
    canvasVM.setCurrentFactory(EllipseFactory.getInstance());
    canvasVM.setCanvasDraggable(true);
  }
}