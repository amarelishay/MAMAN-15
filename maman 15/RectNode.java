/**
 * The RectNode class will represent a node in a linked list that has a rectangle.
 * Elishay Amar I.D 318840394
 */
public class RectNode
{
    private RectangleA _rect;
    private RectNode _next;
    /**
     * A constructor that receives a rectangle, the next _ field will be initialized to null
     * @param r represents the rectengle that the method recives.
     * @return the RectNode that as been crated. 
     */
    public RectNode(RectangleA r){
        _rect=new RectangleA(r);
        _next=null;
    }

    /**
     * A constructor that receives a rectangle and another member of the RectNode type, and initializes the properties according to the parameters.
     * @param r represents the rectengle that the method recives.
     * @param n represents the RectNode member that the method recives.
     * @return the RectNode that as been crated. 
     */
    public RectNode(RectangleA r, RectNode n){
        _rect=new RectangleA(r);
        _next=n;
    }

    /**
     * A copy constructor
     * @param r represents the RectNode that the method recives.
     * @return the RectNode that as been crated. 
     */
    public RectNode(RectNode r){
        _next=r._next;
        _rect=new RectangleA(r._rect);
    }

    /**
     * A method that returns a copy of the rectangle in the member.
     * @retutn a copy of the rectangle in the member.
     */
    public  RectangleA getRect()
    {
        return new RectangleA(_rect);
    }

    /**
     * A method that returns a pointer to the next organ in the list.
     * @return a pointer to the next organ in the list.
     */
    public RectNode getNext(){

        return _next;
    }

    /**
     * A method that receives a rectangle and updates the properties of the rectangle in the member.
     * @param r represents the rectengle that the method recives.
     */
    public void setRect(RectangleA r){
        _rect=new RectangleA(r);
    }

    /**
     * A method that receives a pointer and updates the pointer feature to the next organ.
     * @param next represents the RectNode member that the method recives.
     */
    public void setNext(RectNode next){
        _next=next;
    }
}
