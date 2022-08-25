
public class tester
{
    public static void main (String [] args ){
        RectangleA rec =new RectangleA(new Point(1,5),1,2);
        RectangleA rec1 =new RectangleA(new Point(2,1),4,5);
        RectangleA rec2 =new RectangleA(new Point(3,4),2,5);
        RectangleA rec3 =new RectangleA(new Point(4,2),2,1);
        RectangleA rec4 =new RectangleA(new Point(9,3),2,2);
        RectangleA rec5 =new RectangleA(new Point(9,3),2,2);
        RectNode node =new RectNode(rec);
        RectNode node1 =new RectNode(rec1);
        RectNode node2 =new RectNode(rec2);
        RectNode node3 =new RectNode(rec3);
        RectNode node4 =new RectNode(rec4);
        RectNode node5 =new RectNode(rec5);
        RectList list = new RectList(node);
        node.setNext(node1);
        node1.setNext(node2);
        node2.setNext(node3);
        node3.setNext(node4);
        list.addRect(new RectangleA(new Point(6,8),2,2));
        System.out.println(list.howManyWithPoint(new Point(5,9)));
        System.out.println(list.longestDiagonal());
        System.out.println(list.mostLeftRect());
        System.out.println(list.highestRect());
        System.out.println(list.minimalContainer());
        System.out.println(list);

    }
}
