class Solution {
  public String performEditorActions(String[][] actions) {
    StringBuilder sb = new StringBuilder();

    Stack<Action> undo = new Stack<>(); // Track the most recent actions that we want to undo
    Stack<Action> redo = new Stack<>();

    for (String[] a : actions) {
      switch (a[0]) {
        case "INSERT":
          performInsertChar(a[1].charAt(0), undo, sb);
          redo.clear();

          break;

        case "DELETE":
          performDeleteChar(undo, sb);
          redo.clear();

          break;

        case "UNDO":
          Action undoAction = undo.pop();

          if (undoAction.type == ActionType.INSERT) {
            performInsertChar(undoAction.character, redo, sb);
          } else if (undoAction.type == ActionType.DELETE) {
            performDeleteChar(redo, sb);
          }

          break;

        case "REDO":
          if (redo.size() != 0) {
            Action redoAction = redo.pop();

            if (redoAction.type == ActionType.INSERT) {
              performInsertChar(redoAction.character, undo, sb);
            } else if (redoAction.type == ActionType.DELETE) {
              performDeleteChar(undo, sb);
            }
          }

          break;
      }
    }

    return sb.toString();
  }

  private void performInsertChar(Character c, Stack<Action> destinationStack, StringBuilder sb) {
    sb.append(c);

    Action oppositeAction = new Action(ActionType.DELETE);
    destinationStack.push(oppositeAction);
  }

  private void performDeleteChar(Stack<Action> destinationStack, StringBuilder sb) {
    int indexToRemove = sb.length() - 1;
    char character = sb.charAt(indexToRemove);

    sb.deleteCharAt(indexToRemove);

    Action oppositeAction = new Action(character, ActionType.INSERT);
    destinationStack.push(oppositeAction);
  }

  private class Action {
    Character character;
    ActionType type;

    public Action(Character character, ActionType type) {
      this.character = character;
      this.type = type;
    }

    public Action(ActionType type) {
      this(null, type);
    }
  }

  private enum ActionType {
    INSERT, // Insert the character
    DELETE, // Delete the most recently added character
    UNDO, // Undo the most recent action
    REDO // Redo the most recent undo
  }
}