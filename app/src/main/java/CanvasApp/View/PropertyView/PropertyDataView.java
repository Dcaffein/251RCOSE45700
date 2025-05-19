package CanvasApp.View.PropertyView;

import CanvasApp.View.PropertyView.EventHandler.PropertyDataEventHandler;
import CanvasApp.ViewModel.CanvasVM;
import CanvasApp.ViewModel.Command.ShapeCmd.Move;
import CanvasApp.ViewModel.Command.ShapeCmd.Realign;
import CanvasApp.ViewModel.Command.ShapeCmd.Resize;
import CanvasApp.ViewModel.Data.PropertyData.Event.PropertyDataChanged;
import CanvasApp.ViewModel.Data.PropertyData.Event.PropertyDataObserver;
import CanvasApp.ViewModel.Data.PropertyData.PropertyData;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PropertyDataView extends JPanel implements PropertyViewContext {
    private final PropertyData data;
    private final CanvasVM vm;
    private final JTextField xField = new JTextField(5);
    private final JTextField yField = new JTextField(5);
    private final JTextField wField = new JTextField(5);
    private final JTextField hField = new JTextField(5);
    private final JTextField zField = new JTextField(5);
    private final PropertyDataObserver eventHandler;

    public PropertyDataView(CanvasVM vm, PropertyData data) {
        this.vm = vm;
        this.data = data;
        eventHandler = new PropertyDataEventHandler(this);
        data.attach(eventHandler);

        setLayout(new GridLayout(5, 2, 4, 4));
        add(new JLabel("X:")); add(xField);
        add(new JLabel("Y:")); add(yField);
        add(new JLabel("W:")); add(wField);
        add(new JLabel("H:")); add(hField);
        add(new JLabel("Z:")); add(zField);

        setupField(xField, this::commitX);
        setupField(yField, this::commitY);
        setupField(wField, this::commitW);
        setupField(hField, this::commitH);
        setupField(zField, this::commitZ);

        updateFields(data);
    }

//    @Override
//    public void onUpdate(PropertyDataChanged event) {
//        updateFields(event.source);
//    }

    private void setupField(JTextField field, Runnable commit) {
        field.addActionListener(e -> commit.run());
        field.addFocusListener(new FocusAdapter() {
            @Override public void focusLost(FocusEvent e) { commit.run(); }
        });
    }

    private int parseField(String text) {
        return "--".equals(text) ? -1 : Integer.parseInt(text);
    }

    private void commitX() {
        int newX = parseField(xField.getText());
        int oldX = data.getX();
        if (newX != oldX) {
            vm.handleCmd(new Move(vm, newX - (oldX == -1? 0 : oldX), 0));
        }
    }
    private void commitY() {
        int newY = parseField(yField.getText());
        int oldY = data.getY();
        if (newY != oldY) {
            vm.handleCmd(new Move(vm, 0, newY - (oldY == -1? 0 : oldY)));
        }
    }
    private void commitW() {
        int newW = parseField(wField.getText());
        int oldW = data.getW();
        if (newW != oldW) {
            vm.handleCmd(new Resize(vm, newW - (oldW==-1?0:oldW), 0));
        }
    }
    private void commitH() {
        int newH = parseField(hField.getText());
        int oldH = data.getH();
        if (newH != oldH) {
            vm.handleCmd(new Resize(vm, 0, newH - (oldH==-1?0:oldH)));
        }
    }
    private void commitZ() {
        int newZ = parseField(zField.getText());
        int oldZ = data.getZ();
        if ( newZ != oldZ) {
            vm.handleCmd(new Realign(vm, newZ));
        }
    }

    public void updateFields(PropertyData data) {
        System.out.printf(
                "[PropertyView] beforeUpdateData : X:%s  Y:%s  W:%s  H:%s  Z:%s%n",
                data.getX(), data.getY(), data.getW(), data.getH(), data.getZ());

        String xs = data.getX() == -1 ? "--" : String.valueOf(data.getX());
        String ys = data.getY() == -1 ? "--" : String.valueOf(data.getY());
        String ws = data.getW() == -1 ? "--" : String.valueOf(data.getW());
        String hs = data.getH() == -1 ? "--" : String.valueOf(data.getH());
        String zs = data.getZ() == -1 ? "--" : String.valueOf(data.getZ());

        xField.setText(xs);
        yField.setText(ys);
        wField.setText(ws);
        hField.setText(hs);
        zField.setText(zs);
    }
}
