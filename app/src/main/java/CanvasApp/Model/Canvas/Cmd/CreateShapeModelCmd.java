package CanvasApp.Model.Canvas.Cmd;

import CanvasApp.Model.Canvas.CanvasModel;
import Command.Command;

public interface CreateShapeModelCmd extends Command {
    void Complete(CanvasModel canvasModel,int x, int y, int w, int h, int z);
}
