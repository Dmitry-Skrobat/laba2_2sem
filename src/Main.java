import java.util.Random;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        DynamicArray array = new DynamicArray();
        Scanner scanner = new Scanner(System.in);
        int flag;
        int num;

        do {
            System.out.println("""
                    1 - Создать двусвязный список, заполненный случайными числами от 0 до 99
                    (пользователь вводить количество элементов) и определить его время создания.
                    2 - Создать двусвязный список,пользователь сам вводит элементы списка, определить время его создания
                    3 - Удалить элемент списка по индексу и определить время
                    4 - Удалить элемент списка по значению и определить время
                    5 - Вставка элемента списка по индексу и определить время
                    6 - Получения индекса в списке введенного элемента и определить время
                    7 - Получение значения списка, по введенному индексу и определить время
                    8 - Обмен двух элементов списка и определить время
                    9 - Создать динамический массив, заполненный случайными числами от 0 до 99
                    (пользователь вводить количество элементов) и определить его время создания.
                    10 - Создать динамический массив,пользователь сам вводит элементы списка, определить время его создания
                    11 - Удалить элемент динамического массива по индексу и определить время
                    12 - Удалить элемент динамического массива по значению и определить время
                    13 - Вставка элемента динамического массива по индексу и определить время.
                    14 - Получения индекса динамического массива введенного элемента и определить время
                    15 - Получение значения динамического массива, по введенному индексу и определить время
                    16 - Обмен двух элементов динамического массива и определить время
                    
                    ИДЗ
                    17 - Удалить четные числа в динамическом массиве и найти время
                    18 - Удалить четные числа в списке и найти время
                    """);
            System.out.print("Введите число: ");
            num = scanner.nextInt();
            switch (num) {
                case 1:
                    System.out.print("Введите какое количество элементов вы хотите добавить в список: ");
                    int count;
                    count = scanner.nextInt();
                    Random random = new Random();

                    for (int i = 0; i < count; i++) {
                        list.add(random.nextInt(100));
                    }
                    System.out.println("Сгенерированный список");
                    list.printList();
                    System.out.println();

                    long creationTime = list.calculateCreationTime(count);
                    System.out.println("Время создания списка " + creationTime + " наносекунд");
                    System.out.println();
                    break;
                case 2:
                    System.out.print("Введите элементы списка через запятую: ");
                    String input = scanner.next();
                    String[] elements = input.split(",");
                    int countNum = elements.length;

                    for (String element : elements) {
                        int el = Integer.parseInt(element);
                        list.add(el);
                    }
                    System.out.println("Список введенных элементов: ");
                    list.printList();
                    System.out.println();
                    long time = list.calculateCreationTime(countNum);
                    System.out.println("Время создания списка " + time + " наносекунд");
                    System.out.println();
                    break;

                case 3:
                    System.out.println("Список без изменения: ");
                    list.printList();
                    System.out.println();
                    System.out.print("Введите индекс элемента, который хотите удалить: ");
                    int index = scanner.nextInt();
                    System.out.println();
                    long times = list.deleteByIndex(index);
                    System.out.println("Обновленный список:");
                    list.printList();
                    System.out.println();
                    System.out.println("Время затраченное на удаление элемента списка по индексу " + times + " наносекунд");
                    System.out.println();
                    break;

                case 4:
                    System.out.println("Список без изменения: ");
                    list.printList();
                    System.out.println();
                    System.out.print("Введите элемент, который хотите удалить: ");
                    int value = scanner.nextInt();
                    System.out.println();
                    long timer = list.deleteByValue(value);
                    if (timer != 0) {
                        System.out.println("Обновленный список:");
                        list.printList();
                        System.out.println();
                        System.out.println("Время затраченное на удаление элемента списка по значению " + timer + " наносекунд");
                    }
                    else {
                        System.out.println("Ошибка элемент не найден");
                    }
                    System.out.println();
                    break;

                case 5:
                    System.out.println("Список без изменения: ");
                    list.printList();
                    System.out.println();
                    System.out.print("Введите элемент, который хотите вставить: ");
                    int valueInsert = scanner.nextInt();
                    System.out.print("Введите индекс, куда хотите вставить элемент: ");
                    int indexInsert = scanner.nextInt();
                    long timeInsert = list.insertByIndex(indexInsert,valueInsert);
                    System.out.println("Обновленный список:");
                    list.printList();
                    System.out.println();
                    System.out.println("Время затраченное на удаление элемента списка по значению " + timeInsert + " наносекунд");
                    System.out.println();
                    break;
                case 6:
                    System.out.println("Список: ");
                    list.printList();
                    System.out.println();
                    System.out.print("Введите индекс, элемент которого хотите получить: ");
                    int getIndex = scanner.nextInt();
                    long timeGetIndex = list.getIndexByData(getIndex);
                    System.out.println("Время затраченное на поиск элемента введенного индекса " + timeGetIndex + " наносекунд");
                    System.out.println();
                    break;
                case 7:
                    System.out.println("Список: ");
                    list.printList();
                    System.out.println();
                    System.out.print("Введите элемент, индекс которого хотите получить: ");
                    int getData = scanner.nextInt();
                    long timeGetData = list.getDataByIndex(getData);
                    System.out.println("Время затраченное на поиск индекса введенного элемента " + timeGetData + " наносекунд");
                    System.out.println();
                    break;
                case 8:
                    System.out.println("Список: ");
                    list.printList();
                    System.out.println();
                    System.out.print("Введите индексы списка, которые вы хотите поменять местами: ");
                    int index1Swap = scanner.nextInt();
                    int index2Swap = scanner.nextInt();
                    long timeSwap = list.swapNodes(index1Swap, index2Swap);
                    System.out.println("Обновленный список:");
                    list.printList();
                    System.out.println();
                    System.out.println("Время затраченное на перестановку по индексам " + timeSwap + " наносекунд");
                    System.out.println();

                case 9:
                    System.out.print("Введите какое количество элементов вы хотите добавить в динамический массив: ");
                    int size;
                    size = scanner.nextInt();
                    Random randomArray = new Random();

                    for (int i = 0; i < size; i++) {
                        array.addArrayElement(randomArray.nextInt(100));
                    }
                    System.out.println("Сгенерированный динамический массив");
                    array.printArray();
                    System.out.println();

                    long createTimeDynamicArray = array.calculateCreationTimeDynamicArray(size);
                    System.out.println("Время создания динамического массива " + createTimeDynamicArray + " наносекунд");
                    System.out.println();

                    break;

                case 10:
                    System.out.print("Введите элементы динамического массива через запятую: ");
                    String inputElements = scanner.next();
                    String[] elementsArray = inputElements.split(",");
                    int countElements = elementsArray.length;

                    for (String element : elementsArray) {
                        int el = Integer.parseInt(element);
                        array.addArrayElement(el);
                    }
                    System.out.println("Список введенных элементов: ");
                    array.printArray();
                    System.out.println();
                    long timeShow = array.calculateCreationTimeDynamicArray(countElements);
                    System.out.println("Время создания списка " + timeShow + " наносекунд");
                    System.out.println();
                    break;

                case 11:
                    System.out.println("Динамический массив без изменений: ");
                    array.printArray();
                    System.out.print("Введите индекс элемента, который хотите удалить: ");
                    int indexArray = scanner.nextInt();
                    System.out.println();
                    long timeDelete = array.calculateTimeDeleteByIndex(indexArray);
                    System.out.println("Обновленный динамический массив:");
                    array.printArray();
                    System.out.println("Время затраченное на удаление элемента динамического массива по индексу " + timeDelete + " наносекунд");
                    System.out.println();
                    break;
                case 12:
                    System.out.println("Динамический массив без изменений: ");
                    array.printArray();
                    System.out.print("Введите элемент динамического массива, который хотите удалить: ");
                    int valueArray = scanner.nextInt();
                    System.out.println();
                    long timeDeleteValue = array.calculateTimeDeleteByValue(valueArray);
                    System.out.println("Обновленный динамический массив:");
                    array.printArray();
                    System.out.println("Время затраченное на удаление элемента динамического массива по значению " + timeDeleteValue + " наносекунд");
                    System.out.println();
                    break;

                case 13:
                    System.out.println("Динамический массив без изменений: ");
                    array.printArray();
                    System.out.print("Введите индекс динамического массива, куда хотите вставить элемент: ");
                    int arrayIndex = scanner.nextInt();
                    System.out.print("Введите значения, которое хотите вставить: ");
                    int arrayValue = scanner.nextInt();
                    System.out.println();
                    long insertTime = array.dynamicArrayInsertByIndex(arrayIndex,arrayValue);
                    System.out.println("Обновленный динамический массив:");
                    array.printArray();
                    System.out.println("Время затраченное на вставку элемента динамического массива  " + insertTime + " наносекунд");
                    System.out.println();
                    break;
                case 14:
                    System.out.println("Динамический массив: ");
                    array.printArray();
                    System.out.print("Введите индекс для получения значения: ");
                    int arrayGetIndex = scanner.nextInt();
                    System.out.println();
                    long timeGetByIndex = array.getElementByIndex(arrayGetIndex);
                    System.out.println("Время затраченное на получение значения " + timeGetByIndex + " наносекунд");
                    System.out.println();
                    break;

                case 15:
                    System.out.println("Динамический массив: ");
                    array.printArray();
                    System.out.print("Введите значение, чтобы получить индекс: ");
                    int arrayGetValue = scanner.nextInt();
                    System.out.println();
                    long timeGetByValue = array.getElementByValue(arrayGetValue);
                    System.out.println("Время затраченное на получение значения " + timeGetByValue + " наносекунд");
                    System.out.println();
                    break;
                case 16:
                    System.out.println("Динамический массив: ");
                    array.printArray();
                    System.out.println();
                    System.out.print("Введите значения индексы, которые вы хотите поменять местами: ");
                    int indexSwap1 = scanner.nextInt();
                    int indexSwap2 = scanner.nextInt();
                    long timeSwapArray = array.swapArrayElements(indexSwap1,indexSwap2);
                    System.out.println("Обновленный динамический массив:");
                    array.printArray();
                    System.out.println("Время затраченное обмен значений по введенным индекса " + timeSwapArray + " наносекунд");
                    System.out.println();
                    break;

                case 17:
                    System.out.println("Динамический массив с четными числами: ");
                    array.printArray();
                    System.out.println();
                    long timeDeleteEvenAtArray = array.deleteEvenInArray();
                    System.out.println("Обновленный динамический массив:");
                    array.printArray();
                    System.out.println("Время затраченное удаление четных элементов из динамическго массива " + timeDeleteEvenAtArray+ " наносекунд");
                    System.out.println();
                    break;

                case 18:
                    System.out.println("Список с четными числами: ");
                    list.printList();
                    System.out.println();
                    long timeDeleteEvenInList= list.deleteEvenInList();
                    System.out.println("Обновленный список:");
                    list.printList();
                    System.out.println();
                    System.out.println("Время затраченное удаление четных элементов из списка " + timeDeleteEvenInList+ " наносекунд");
                    System.out.println();
                    break;
                case 19:
                    System.out.println("Список: ");
                    list.printList();
                    System.out.println();
                    int num1 = scanner.nextInt();
                    list.findTwo(num1);
                    list.printList();
            }
            System.out.print("Введите 1, если хотите закончить программу, иначе введите 0: ");
            flag = scanner.nextInt();
        }while (flag == 0);

    }
}