package CanvasApp.ViewModel.ShapeViewModel.EventHandler;

import CanvasApp.Model.Decorator.Event.InnerUndecorated;
import CanvasApp.ViewModel.ShapeViewModel.Event.DecoCompositionChanged;
import CanvasApp.ViewModel.ShapeViewModel.ShapeViewModel;
import Observer.Event;

public class OnDecoCompositionChanged implements ShapeViewModelEventHandler {
    @Override
    public void handle(ShapeViewModel viewModel, Event<?> event) {
        if(event instanceof InnerUndecorated e){
            viewModel.notify(new DecoCompositionChanged(e.source));
        }
    }
}
