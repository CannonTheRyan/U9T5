import java.util.ArrayList;

public class Cabaret
{
    private String name;
    private ArrayList<Performer> performers;

    public Cabaret(String name)
    {
        this.name = name;
        performers = new ArrayList<>();
    }

    public boolean addPerformer(Performer performer)
    {
        if (performers.indexOf(performer) == -1)
        {
            performers.add(performer);
            return true;
        }
        return false;
    }

    public boolean removePerformer(Performer performer)
    {
        for (int i = 0; i < performers.size(); i++)
        {
            if (performers.get(i).equals(performer))
            {
                performers.remove(i);
                return true;
            }
        }
        return false;
    }

    public double averagePerformerAge()
    {
        int age = 0;
        for (Performer p : performers)
        {
            age += p.getAge();
        }
        return 1.0 * age / performers.size();
    }

    public ArrayList<Performer> performersOverAge(int age)
    {
        ArrayList<Performer> returnList = new ArrayList<>();
        for (Performer p : performers)
        {
            if (p.getAge() >= age)
            {
                returnList.add(p);
            }
        }
        return returnList;
    }

    public void groupRehearsal()
    {
        for (Performer p : performers)
        {
            System.out.println("REHEARSAL CALL! " + p.getName());
            if (p instanceof Comedian)
            {
                ((Comedian) p).rehearse(false);
            }
            else
            {
                p.rehearse();
            }
        }
    }

    public void cabaretShow()
    {
        for (Performer p : performers)
        {
            System.out.println("Welcome to the cabaret! Next act up... " + p.getName());
            if (p instanceof Dancer)
            {
                ((Dancer) p).pirouette(2);
            }
            p.perform();
        }
    }

    public String getName()
    {
        return name;
    }

    public ArrayList<Performer> getPerformers()
    {
        return performers;
    }
}
