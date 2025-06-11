package CanvasApp.Model.Decorator;

import CanvasApp.Model.Decorator.Event.DecoratorStateChanged;
import CanvasApp.Model.Decorator.Event.InnerUndecorated;
import CanvasApp.Model.Event.ShapeMoved;
import CanvasApp.Model.Event.ShapeReplaced;
import CanvasApp.Model.Event.ShapeResized;
import CanvasApp.Model.Event.ShapeRealigned;

import CanvasApp.Model.ShapeModel;

import java.util.List;

public abstract class ShapeDecorator extends ShapeModel {
    protected ShapeModel decorated;

    public ShapeDecorator(ShapeModel decorated) {
        this.decorated = decorated;
    }

    public ShapeModel getDecorated(){
        return decorated;
    }

    @Override
    public String getId() {
        return decorated.getId();
    }

    @Override
    public int getX() {
        return decorated.getX();
    }

    @Override
    public int getY() {
        return decorated.getY();
    }

    @Override
    public int getW() {
        return decorated.getW();
    }

    @Override
    public int getH() {
        return decorated.getH();
    }

    @Override
    public int getZ() {
        return decorated.getZ();
    }

    @Override
    public void moveBy(int dx, int dy) {
        decorated.moveBy(dx, dy);
        notify(new ShapeMoved(this));
    }

    @Override
    public void resizeBy(int dw, int dh) {
        decorated.resizeBy(dw, dh);
        notify(new ShapeResized(this));
    }

    @Override
    public void moveTo(int newX, int newY) {
        decorated.moveTo(newX, newY);
        notify(new ShapeMoved(this));
    }

    @Override
    public void resizeAs(int newW, int newH) {
        decorated.resizeAs(newW, newH);
        notify(new ShapeResized(this));
    }

    @Override
    public void realign(int newZ) {
        decorated.realign(newZ);
        notify(new ShapeRealigned(this));
    }

    @Override
    public void addChild(ShapeModel shapeModel) {
        decorated.addChild(shapeModel);
    }

    @Override
    public void removeChild(ShapeModel shapeModel) {
        decorated.removeChild(shapeModel);
    }

    @Override
    public void replace(ShapeModel oldOne, ShapeModel newOne) {
        notify(new ShapeReplaced(newOne));
    }

    @Override
    public void clear() {
        decorated.clear();
    }

    @Override
    public List<ShapeModel> getChildren() {
        return decorated.getChildren();
    }

    @Override
    public ShapeModel getChild(String id) {
        return decorated.getChild(id);
    }

    public abstract void updateOwnState(ShapeDecorator decorator);

    public void updateDecorateState(ShapeDecorator decorator){
        ShapeDecorator target = getDecorator(decorator.getClass());
        if(target==null) return;
        target.updateOwnState(decorator);
        notify(new DecoratorStateChanged(target));
    }

    public ShapeDecorator getDecorator(Class<? extends ShapeDecorator> targetClass){
//        System.out.println("[getDecorator] : this.getClass(): " + this.getClass());
//        System.out.println("[getDecorator] : targetClass: " + targetClass);
//        System.out.println("[getDecorator] : this.getClass().equals(targetClass): " + this.getClass().equals(targetClass));
        if (this.getClass().equals(targetClass)){
//            System.out.println("[getDecorator] this.getClass().equals(targetClass): this: " + this);
            return this;
        }

        if (!(decorated instanceof ShapeDecorator)){
            return null;
        } else {
            return ((ShapeDecorator) decorated).getDecorator(targetClass);
        }
    }

    public void removeDecorator(Class<? extends ShapeDecorator> targetClass, ShapeDecorator wrapper, ShapeDecorator outterMost) {
        if (getDecorator(targetClass) != null){
            if(wrapper!=null) {
                wrapper.decorated = decorated;
                outterMost.notify(new InnerUndecorated(this));
            }
        }

        if (decorated instanceof ShapeDecorator){
            ((ShapeDecorator) decorated).removeDecorator(targetClass,outterMost,this);
        }
    }
}
