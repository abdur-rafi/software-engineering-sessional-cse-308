package Editor;

import Editor.Font.FontFactory;
import Editor.parser.ParserFactory;

public class EditorFactoryProducer {
    private static EditorAbstractFactory fontFactory = new FontFactory();
    private static EditorAbstractFactory parserFactory = new ParserFactory();
    public static EditorAbstractFactory getFactory(String type){
        if (type.equalsIgnoreCase("font")){
            return fontFactory;
        }
        else if(type.equalsIgnoreCase("parser")){
            return parserFactory;
        }
        return null;
    }
}
