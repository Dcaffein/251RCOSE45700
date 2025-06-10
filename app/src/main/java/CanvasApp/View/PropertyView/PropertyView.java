package CanvasApp.View.PropertyView;

import CanvasApp.ViewModel.PropertyViewModel.Cmd.MoveTo;
import CanvasApp.ViewModel.PropertyViewModel.Cmd.Realign;
import CanvasApp.ViewModel.PropertyViewModel.Cmd.ResizeAs;
import CanvasApp.ViewModel.PropertyViewModel.PropertyViewModel;
import Observer.Observer;
import Observer.Event;

import javax.swing.*;
import java.awt.*;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class PropertyView extends JPanel implements Observer {
    private final PropertyViewModel viewModel;
    private final JTextField xField = new JTextField(5);
    private final JTextField yField = new JTextField(5);
    private final JTextField wField = new JTextField(5);
    private final JTextField hField = new JTextField(5);
    private final JTextField zField = new JTextField(5);

    public PropertyView(PropertyViewModel viewModel) {
        this.viewModel = viewModel;
        viewModel.attach(this);

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

        updateFields();
    }

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
        int oldX = viewModel.getX();
        if (newX != oldX) {
            System.out.println("[commit] newX : " + newX + ", newY : " + viewModel.getY());
            (new MoveTo(viewModel, newX, viewModel.getY())).execute();
        }
    }
    private void commitY() {
        int newY = parseField(yField.getText());
        int oldY = viewModel.getY();
        if (newY != oldY) {
            (new MoveTo(viewModel, viewModel.getX(), newY)).execute();
        }
    }
    private void commitW() {
        int newW = parseField(wField.getText());
        int oldW = viewModel.getW();
        if (newW != oldW) {
            (new ResizeAs(viewModel, newW, viewModel.getH())).execute();
        }

    }
    private void commitH() {
        int newH = parseField(hField.getText());
        int oldH = viewModel.getH();
        if (newH != oldH) {
            (new ResizeAs(viewModel, viewModel.getW(), newH)).execute();
        }
    }
    private void commitZ() {
        int newZ = parseField(zField.getText());
        int oldZ = viewModel.getZ();
        if ( newZ != oldZ) {
            (new Realign(viewModel, newZ)).execute();
        }
    }

    public void updateFields() {
//        System.out.printf(
//                "[PropertyView] beforeUpdateData : X:%s  Y:%s  W:%s  H:%s  Z:%s%n",
//                data.getX(), data.getY(), data.getW(), data.getH(), data.getZ());

        int x = viewModel.getX();
        int y = viewModel.getY();
        int w = viewModel.getW();
        int h = viewModel.getH();
        int z = viewModel.getZ();
        String xString = x == -1 ? "--" : String.valueOf(x);
        String yString = y == -1 ? "--" : String.valueOf(y);
        String wString = w == -1 ? "--" : String.valueOf(w);
        String hString = h == -1 ? "--" : String.valueOf(h);
        String zString = z == -1 ? "--" : String.valueOf(z);

        xField.setText(xString);
        yField.setText(yString);
        wField.setText(wString);
        hField.setText(hString);
        zField.setText(zString);
    }

    @Override
    public void onUpdate(Event<?> event) {
        updateFields();
    }
}
