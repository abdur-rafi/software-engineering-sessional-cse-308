package Editor;

import Editor.Font.Font;
import Editor.Font.FontFactory;
import Editor.parser.Parser;
import Editor.parser.ParserFactory;

public class Editor {

    private static final Editor editor = new Editor();
    private FontFactory fontFactory = new FontFactory();
    private ParserFactory parserFactory = new ParserFactory();
    public static Editor getEditor(){
        return editor;
    }


    private Editor(){

    }

    public void Parse(String fileName){
        String[] tokens = fileName.split("\\.");
        String extension = tokens[tokens.length - 1];
        Font font;
        Parser parser;
        if(extension.equalsIgnoreCase("c")){
            font = fontFactory.getFont("courier");
            parser = parserFactory.getParser("c");
        }
        else if(extension.equalsIgnoreCase("cpp")){
            font = fontFactory.getFont("monaco");
            parser = parserFactory.getParser("cpp");
        }
        else if(extension.equalsIgnoreCase("py")){
            font = fontFactory.getFont("consolas");
            parser = parserFactory.getParser("python");
        }
        else {
            System.out.println("unsupported extension type");
            return;
        }
        System.out.println("parsing " + fileName);
        System.out.println("Parser language : " + parser.getLanguage());
        System.out.println("Font: "+ font.getFontName());
    }
}
