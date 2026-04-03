import java.util.*;

public class TextEditor {

    private String text = "";
    private Stack<String> undoStack = new Stack<>();
    private Stack<String> redoStack = new Stack<>();

    // Type new text
    public void type(String newText) {
        undoStack.push(text);   // save current state
        text += newText;        // update text
        redoStack.clear();      // clear redo history
    }

    // Undo operation
    public void undo() {
        if (!undoStack.isEmpty()) {
            redoStack.push(text);
            text = undoStack.pop();
        } else {
            System.out.println("Nothing to undo");
        }
    }

    // Redo operation
    public void redo() {
        if (!redoStack.isEmpty()) {
            undoStack.push(text);
            text = redoStack.pop();
        } else {
            System.out.println("Nothing to redo");
        }
    }

    // Display current text
    public void print() {
        System.out.println("Text: " + text);
    }

    public static void main(String[] args) {
        TextEditor editor = new TextEditor();

        editor.type("Hello");
        editor.print();

        editor.type(" World");
        editor.print();

        editor.undo();
        editor.print();

        editor.redo();
        editor.print();
    }
}