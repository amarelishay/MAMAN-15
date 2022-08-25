/**
 * The RectList class will represent a linked list of rectangles.
 * The representation is made by a list that keeps track of the list of rectangles.
 * Elishay Amar I.D 318840394
 */
public class RectList
{
    private RectNode _head;
    /**
     * A builder that creates an empty list - initializes the top of the list to be null.
     */
    public RectList (){
        _head=null;
    }

    /**
     * A method that receives as a rectangle parameter and adds it to the end of the list. 
     * If this rectangle is already on the list, the method will do nothing.
     * @param RectangleA represents the rectangle that the method recives.
     */

    public void addRect(RectangleA r)/*
    The algorithm checks to see if the rectangle is present in the list, if so, then isthere  is true and the method will end.
    When we reach the end of the list, the method will add the rectangle to the last element.
    A rectangle will be added to the first cell in the list if the list is empty.

     */
    {  
        boolean isthere=false,last=false;
        if (_head==null){
            _head=new RectNode(r);
        }
        else {
            RectNode temp=_head;
            while (last==false&&isthere==false){
                if (temp.getRect().equals(r))
                    isthere=true;
                if (temp.getNext()==null)
                    last=true;
                else
                    temp=temp.getNext();
            }
            if (isthere==false)
                temp.setNext(new RectNode(r));
        }
    }

    /**
     * A method that receives as a parameter a point p (object from the Point class)
     * And returns the number of rectangles in the list whose southwestern point is p.
     * If there are no rectangles in the list (i.e. the list is empty) or there are no rectangles in the list whose point p is southwest, 
     * the method will return 0.
     * @param p represents the point that the method recives.
     * @return the number of rectangles in the list whose southwestern point is p.
     */

    public int howManyWithPoint (Point p){/*
        For each cell on the list, the algorithm compares the point SW to p in each rectangle.
        If the points are equal the count will increase by 1.
        And finally the method will return its value
         */
        if (_head==null)return 0;
        int counter =0;
        RectNode temp=new RectNode(_head);
        while (temp!=null)
        {
            if (temp.getRect().getPointSW().equals(p))
                counter++;
            temp=temp.getNext();
        }
        return counter;
    }

    /**
     * A method that returns the longest diagonal length between all the rectangles in the list.
     * If there are no rectangles in the list (ie the list is empty) the method will return 0.
     * @return the longest diagonal length between all the rectangles in the list.
     */
    public double longestDiagonal (){/*
        The algorithm goes through each member of the list and compares the diagonal value in its rectangle to longest if it is larger it 
        will be applied in the variable.
        Finally the algorithm returns longest.
         */
        if (_head==null)return 0;
        double longest=0;
        RectNode temp=new RectNode(_head); 
        while (temp!=null)
        {
            if (temp.getRect().getDiagonalLength()>longest)
                longest=temp.getRect().getDiagonalLength();
            temp=temp.getNext();       
        }
        return longest;
    }

    /**
     * A method that returns a copy of the southwestern point of the leftmost rectangle on the list.
     * If there is more than one rectangle that is the leftmost, the method returns a copy of the southwest point of
     * The first rectangle among them on the list. If there are no rectangles in the list (i.e.
     * The list is empty) The method will return null.
     * @return a copy of the southwestern point of the leftmost rectangle on the list.
     */
    public Point mostLeftRect (){/*
        At first the algorithm checks if the list is empty and if not it defines p as a copy of the SW point of the first cell in the list.
        The algorithm then goes over each rectangle in the list and using the isLeft method of Point class checks if the SW point of the 
        tested rectangle is to the left of p.
        If so the algorithm updates the point p to the point value that has just been tested.
        Finally the algorithm returns the point p.
         */
        if(_head==null)return null;

        Point p=new Point(_head.getRect().getPointSW());
        RectNode temp=new RectNode(_head);
        while (temp!=null)
        {
            if (temp.getRect().getPointSW().isLeft(p))
                p=new Point (temp.getRect().getPointSW());
            temp=temp.getNext();      
        }
        return p;
    }

    /**
     * A method that returns a copy of the northeast spot of the highest rectangle.
     * If there is more than one rectangle at the highest height,
     * The method returns a copy of the northeastern point of the first rectangle on the list.
     * If there are no rectangles in the list (i.e. the list is empty) the method will return null.
     * @return a copy of the northeast spot of the highest rectangle.
     */

    public Point highestRect (){/*
        At first the algorithm checks if the list is empty and if not it defines p as a copy of the NE point of the first cell in the list.
        The algorithm then goes over each rectangle in the list and using the isAbove method of the Point class checks if the NE point of the 
        tested rectangle is above p.
        If so the algorithm updates the point p to the point value that has just been tested.
        Finally the algorithm returns the point p.
         */
        if(_head==null)return null;

        Point p=new Point(_head.getRect().getPointNE());
        RectNode temp=new RectNode(_head);
        while (temp!=null)
        {
            if (temp.getRect().getPointNE().isAbove(p))
                p=new Point (temp.getRect().getPointNE());
            temp=temp.getNext();      
        }
        return p;
    }

    /**
     * Method that returns a new rectangle (object from the RectangleA class)
     * Which is the rectangle with the minimum area that contains all the rectangles in the list. 
     * If there are no rectangles
     * In the list (i.e. the list is empty) the method will return null.
     * @return a new rectangle which is the rectangle with the minimum area that contains all the rectangles in the list. 
     */
    public RectangleA minimalContainer(){/*This algorithm finds the endpoints of the smallest rectangle (SW and NE, by using the methods: highestRect,mostLeftRect
        ,isRight method of the Point class and isUnder method of the Point class. On all the rectangles in the list.)
        and uses them to create an new rectangle and returns it. 
         */
        if(_head==null)return null;
        Point pointNE=new Point(highestRect());
        Point pointSW=new Point (mostLeftRect ());
        RectNode temp=new RectNode(_head);
        while (temp!=null)
        {    
            if(temp.getRect().getPointNE().isRight(pointNE))
                pointNE.setX(temp.getRect().getPointNE().getX());
            if (temp.getRect().getPointSW().isUnder(pointSW))
                pointSW.setY(temp.getRect().getPointSW().getY());
            temp=temp.getNext();
        }
        return new RectangleA(pointSW,pointNE);
    }

    /**
     * A method that returns a string that represents the list of rectangles.
     * @return a string that represents the list of rectangles.
     */

    public String toString(){/*
        At first the algorithm checks if the list is empty, if so then the method will print "The list has 0 rectangles".
        If the list is not empty the algorithm defines an empty string variable called str and then goes over each rectangle in the 
        list to count it and at the same time adds to the str variable the counter and toString method of the RectabgleA class and then descends a line.
        Finally the algorithm will add to str the text "The list has" + counter + "rectangles" and then it will return str.
         */
        if(_head==null)return "The list has 0 rectangles";   
        int counter =0;
        RectNode temp=new RectNode(_head);
        String str="";
        while (temp!=null){
            counter++;    
            str+=counter+". "+temp.getRect()+"\n";
            temp=temp.getNext();
        }
        str="The list has "+counter+" rectangles.\n"+str;
        return str;     
    }
}
