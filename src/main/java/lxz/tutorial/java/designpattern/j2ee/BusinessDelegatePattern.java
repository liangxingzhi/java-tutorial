package lxz.tutorial.java.designpattern.j2ee;

public class BusinessDelegatePattern {

  public static void main(String[] args) {

    BusinessDelegate businessDelegate = new BusinessDelegate();
    businessDelegate.setServiceType("EJB");

    Client client = new Client(businessDelegate);
    client.doTask();

    businessDelegate.setServiceType("JMS");
    client.doTask();
  }

  interface BusinessService {

    public void doProcessing();
  }

  static class EJBService implements BusinessService {

    @Override
    public void doProcessing() {
      System.out.println("Processing task by invoking EJB Service");
    }
  }

  static class JMSService implements BusinessService {

    @Override
    public void doProcessing() {
      System.out.println("Processing task by invoking JMS Service");
    }
  }

  static class BusinessLookUp {

    public BusinessService getBusinessService(String serviceType) {
      if (serviceType.equalsIgnoreCase("EJB")) {
        return new EJBService();
      } else {
        return new JMSService();
      }
    }
  }

  static class BusinessDelegate {

    private BusinessLookUp lookupService = new BusinessLookUp();
    private BusinessService businessService;
    private String serviceType;

    public void setServiceType(String serviceType) {
      this.serviceType = serviceType;
    }

    public void doTask() {
      businessService = lookupService.getBusinessService(serviceType);
      businessService.doProcessing();
    }
  }

  static class Client {

    BusinessDelegate businessService;

    public Client(BusinessDelegate businessService) {
      this.businessService = businessService;
    }

    public void doTask() {
      businessService.doTask();
    }
  }
}
