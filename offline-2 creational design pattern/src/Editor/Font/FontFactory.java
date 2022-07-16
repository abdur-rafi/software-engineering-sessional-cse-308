package Editor.Font;

import Editor.EditorAbstractFactory;

public class FontFactory extends EditorAbstractFactory {

    @Override
    public Font getFont(String type){
        if(type.equalsIgnoreCase("monaco")){
            return new Monaco();
        }
        else if(type.equalsIgnoreCase("courier"))
            return new CourierNew();
        else if(type.equalsIgnoreCase("consolas"))
            return new Consolas();
        return null;
    }
}
