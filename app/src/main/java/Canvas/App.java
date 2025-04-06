package Canvas;

import Canvas.View.CanvasView;
import Canvas.ViewModel.CanvasVM;

import javax.swing.JFrame;

public class App {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Canvas App");
        CanvasVM viewModel = new CanvasVM();
        CanvasView canvasView = new CanvasView(viewModel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800, 600);
        frame.add(canvasView);
        frame.setVisible(true);
    }
}
