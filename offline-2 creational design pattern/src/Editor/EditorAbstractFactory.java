package Editor;

import Editor.Font.Font;
import Editor.parser.Parser;

public abstract class EditorAbstractFactory {
    public Font getFont(String type){
        return null;
    }
    public Parser getParser(String type){
        return null;
    }
}
