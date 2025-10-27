package Etapa3;

public class Etapa3 {

    public boolean checkBrackets(Stack<Character> s1) {
        // Cria uma pilha auxiliar para rastrear parênteses abertos
        Stack<Character> pilhaAbertos = new StaticStack<Character>(s1.numElements());

        // Cria uma cópia da pilha original para não modificá-la
        Stack<Character> copia = copiarPilha(s1);

        // Processa cada caractere da cópia
        while (!copia.isEmpty()) {
            try {
                char c = copia.pop();

                if (c == '(') {
                    // Encontrou um parêntese abrindo - empilha
                    pilhaAbertos.push(c);
                } else if (c == ')') {
                    // Encontrou um parêntese fechando
                    if (pilhaAbertos.isEmpty()) {
                        // Fechamento sem abertura correspondente
                        return false;
                    } else {
                        // Remove a abertura correspondente
                        pilhaAbertos.pop();
                    }
                }
                // Ignora outros caracteres que não são parênteses
            } catch (UnderflowException | OverflowException e) {
                return false;
            }
        }

        // Expressão válida se não sobrou parênteses abertos
        return pilhaAbertos.isEmpty();
    }

    // Método auxiliar para copiar uma pilha
    private Stack<Character> copiarPilha(Stack<Character> original) {
        Stack<Character> copia = new StaticStack<Character>(original.numElements());
        Stack<Character> temp = new StaticStack<Character>(original.numElements());

        // Primeiro transfere para temporária (inverte a ordem)
        while (!original.isEmpty()) {
            try {
                temp.push(original.pop());
            } catch (UnderflowException | OverflowException e) {
                break;
            }
        }

        // Agora transfere de volta para original e para a cópia (restaura ordem)
        while (!temp.isEmpty()) {
            try {
                char elemento = temp.pop();
                original.push(elemento);
                copia.push(elemento);
            } catch (UnderflowException | OverflowException e) {
                break;
            }
        }

        return copia;
    }
}