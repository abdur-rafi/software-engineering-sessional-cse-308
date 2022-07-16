package Editor.parser;

import Editor.EditorAbstractFactory;

public class ParserFactory extends EditorAbstractFactory {

    @Override
    public Parser getParser(String type){
        if(type.equalsIgnoreCase("c")){
            return new CParser();
        }
        else if(type.equalsIgnoreCase("cpp")){
            return new CPPParser();
        }
        else if(type.equalsIgnoreCase("python")){
            return new PythonParser();
        }
        return null;
    }
}
