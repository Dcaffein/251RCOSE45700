package CanvasApp.ViewModel.Datas.PropertyData;

import CanvasApp.Model.Shape.ShapeModel;
import CanvasApp.ViewModel.Datas.PropertyData.Event.PropertyChanged;
import Observer.*;

import java.util.List;

public class PropertyData extends Observable {
    private ShapeModel selected;

    public PropertyData(ShapeModel selected) {
        this.selected = selected;
    }

    private int x = -1;
    private int y = -1;
    private int w = -1;
    private int h = -1;
    private int z = -1;

    public void recalculate() {
        List<ShapeModel> shapes = selected.getChildren().stream().toList();

        if (shapes.isEmpty()) {
            x = y = w = h = z = -1;
        } else {
            int fx = shapes.getFirst().getX();
            x = shapes.stream().allMatch(s -> s.getX() == fx) ? fx : -1;
            int fy = shapes.getFirst().getY();
            y = shapes.stream().allMatch(s -> s.getY() == fy) ? fy : -1;
            int fw = shapes.getFirst().getW();
            w = shapes.stream().allMatch(s -> s.getW() == fw) ? fw : -1;
            int fh = shapes.getFirst().getH();
            h = shapes.stream().allMatch(s -> s.getH() == fh) ? fh : -1;
            int fz = shapes.getFirst().getZ();
            z = shapes.stream().allMatch(s -> s.getZ() == fz) ? fz : -1;
        }

        System.out.printf("[PropertyData] recalc : x=%d, y=%d, w=%d, h=%d, z=%d%n", x, y, w, h, z);
        notify(new PropertyChanged(this));
    }

    public int getX() { return x; }
    public int getY() { return y; }
    public int getW() { return w; }
    public int getH() { return h; }
    public int getZ() { return z; }
}

