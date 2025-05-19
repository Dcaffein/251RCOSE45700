package CanvasApp.ViewModel.Command.ShapeCmd;

import CanvasApp.Factory.DecoratorTextFactory;
import CanvasApp.Model.Decorator.TextInShape;
import CanvasApp.Model.ShapeModel;
import CanvasApp.ViewModel.CanvasVM;
import Command.Command;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public class DecorateWithTextCmd implements Command {
    private final CanvasVM viewModel;
    private final String defaultText;

    public DecorateWithTextCmd(CanvasVM viewModel, String defaultText) {
        this.viewModel = viewModel;
        this.defaultText = defaultText;
    }

    @Override
    public void execute() {
        // CanvasVM.selected는 ShapeModelGroup이므로 getChildren()으로 실제 선택된 모델들을 가져옵니다.
        // ShapeModelGroup.getChildren()은 null을 반환할 수 있으므로 주의해야 합니다.
        // CanvasVM.selected는 ShapeModelGroup이므로 getChildren()을 사용해야 합니다.
        // ShapeModelGroup의 getChildren은 null을 반환하지 않고 빈 컬렉션 또는 자식들을 반환합니다.
        Collection<ShapeModel> selectedShapes = viewModel.selected.getChildren();

        if (selectedShapes == null || selectedShapes.isEmpty()) {
            System.out.println("[DecorateWithTextCmd] No shape selected to decorate with text.");
            return;
        }

        DecoratorTextFactory textFactory = DecoratorTextFactory.getInstance();

        List<ShapeModel> shapesToDecorate = new ArrayList<>(selectedShapes);

        for (ShapeModel originalShape : shapesToDecorate) {
            // TextInShape 모델을 생성합니다. DecoratorTextFactory에 createShapeDecorator 메서드가 있습니다.
            TextInShape textDecorator = textFactory.createShapeDecorator(originalShape, defaultText);

            // 기존 모델-데코레이터 교체 로직은 CanvasVM에 메서드로 만들거나,
            // Model 계층의 DecorateCmd를 사용합니다.
            // 여기서는 Model 계층의 DecorateCmd를 사용한다고 가정합니다.
            // DecorateCmd는 decorated, decorator, canvas를 필요로 합니다.
            // viewModel.getCanvas()와 같은 메서드가 CanvasVM에 필요할 수 있습니다 (canvas 필드에 접근하기 위해).
            // 또는 CanvasVM에 decorateShape(ShapeModel original, ShapeModel decorator) 메서드를 만듭니다.

            // CanvasVM에 위임하는 것이 더 적절해 보입니다.
            viewModel.decorateShapeWithText(originalShape, textDecorator);
        }
    }
}