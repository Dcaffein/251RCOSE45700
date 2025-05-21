package CanvasApp.Model.Cmd;

import CanvasApp.Model.ShapeModel;

import Command.Command;

public class SetSizeBy implements Command{
    private final ShapeModel selected;
    private final int dw,dh;

    public SetSizeBy(ShapeModel selected, int dw, int dh){
        this.selected = selected;
        this.dw = dw;
        this.dh = dh;
    }

    @Override
    public void execute() {
        System.out.println("[SetSizeByCmd execute]. dw : " + dw + ", dh :" + dh);
        selected.setSizeBy(dw, dh);
    }
}
