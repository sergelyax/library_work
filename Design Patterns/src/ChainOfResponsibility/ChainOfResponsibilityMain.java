package ChainOfResponsibility;


abstract class Processor
{
    private Processor nextProcessor;

    public Processor(Processor nextProcessor){
        this.nextProcessor = nextProcessor;
    };

    public void process(Number request){
        if(nextProcessor != null)
            nextProcessor.process(request);
    };
}

class Number
{
    private int number;

    public Number(int number)
    {
        this.number = number;
    }

    public int getNumber()
    {
        return number;
    }

}
class chain {
    Processor chain;

    public chain(){
        buildChain();
    }

    private void buildChain(){
        chain = new NegativeProcessor(new ZeroProcessor(new PositiveProcessor(null)));
    }

    public void process(Number request) {
        chain.process(request);
    }

}
class NegativeProcessor extends Processor
{
    public NegativeProcessor(Processor nextProcessor){
        super(nextProcessor);

    }

    public void process(Number request)
    {
        if (request.getNumber() < 0)
        {
            System.out.println("NegativeProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}

class ZeroProcessor extends Processor
{
    public ZeroProcessor(Processor nextProcessor){
        super(nextProcessor);
    }

    public void process(Number request)
    {
        if (request.getNumber() == 0)
        {
            System.out.println("ZeroProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}

class PositiveProcessor extends Processor
{

    public PositiveProcessor(Processor nextProcessor){
        super(nextProcessor);
    }

    public void process(Number request)
    {
        if (request.getNumber() > 0)
        {
            System.out.println("PositiveProcessor : " + request.getNumber());
        }
        else
        {
            super.process(request);
        }
    }
}

class ChainOfResponsibilityMain {
    public static void main(String[] args) {
        chain chain = new chain();

        //Calling chain of responsibility
        chain.process(new Number(90));
        chain.process(new Number(-50));
        chain.process(new Number(0));
        chain.process(new Number(91));
    }
}
