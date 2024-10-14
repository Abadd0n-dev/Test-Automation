package main.Composite;

public class Client {
    public static void main(String[] args) {
        // Создание листовых узлов
        Component leaf1 = new Leaf("Leaf 1");
        Component leaf2 = new Leaf("Leaf 2");

        // Создание составных узлов
        Composite composite1 = new Composite("Composite 1");
        Composite composite2 = new Composite("Composite 2");

        // Добавление листов в составные узлы
        composite1.add(leaf1);
        composite2.add(leaf2);
        composite2.add(composite1);

        composite2.operation(); // Выполнение операции над компонентами
    }
}
