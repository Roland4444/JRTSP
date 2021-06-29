package se.roland.client.abstractions;

import ru.com.avs.scales.common.Weighing;

import java.math.BigDecimal;

public class WeighingWIthUUID extends Weighing {
    public String UUID;
    public float Brutto__;
    public String Customer;
    public String Customer_ID;
    public float pricePerKg;
    public float formalprice;
    public String IdDepartment;
    public String TransferUUID;
    public String Transit;
    public WeighingWIthUUID(){

    };
    public WeighingWIthUUID(Weighing W){
       // float Brutto, float Sor,String  Metal,String DepId,String PlateNumber ,String UUID,String Type
        this.setDate(W.getDate());
        this.setTime(W.getTime());
        this.setCar(W.getCar());
        this.setTrash(W.getTrash());
        this.setWaybill(W.getWaybill());
        this.setTransfer(W.isTransfer());
        this.setFirstSnapshot(W.getFirstSnapshot());
        this.setSecondSnapshaot(W.getSecondSnapshaot());
        this.setRecPlate(W.getRecPlate());
        this.setBrutto(W.getBrutto());
        this.setSor(W.getSor());
        this.setMetal(W.getMetal());
        this.setDepartment(String.valueOf(W.getDepartment()));
        this.IdDepartment = String.valueOf(getDep(W.getDepartment()));
        this.setPlateNumber(W.getPlateNumber());
        this.setTare(W.getTare());
        if (this.getMetal()=="3А")
            this.setMetal("3A");
        System.out.println("METAL ID="+this.getMetal());
    }

    public void printit(){
        System.out.println("BRUTTO::"+getBrutto());
        System.out.println("TARE::"+getTare());
        System.out.println("TRASH::"+getTrash());
        System.out.println("WAYBILL::"+getWaybill());
        System.out.println("TRANSFER::"+isTransfer());
        System.out.println("RECPLATE::"+getRecPlate());
        System.out.println("DATE::"+getDate());
        System.out.println("TIME::"+getTime());
        System.out.println("CAR::"+getCar());
        System.out.println("METALL::"+getMetal());
        System.out.println("DEPARTMENT::"+getDepartment());
        System.out.println("PLATE NUMBER::"+getPlateNumber());
        System.out.println("CUSTOMER::"+Customer);
        System.out.println("PRICEPER KG::"+pricePerKg);
        System.out.println("UUID::"+UUID);
        System.out.println("DEPART ID::"+IdDepartment);
        System.out.println("WEIGNHING ID::"+getId());
        System.out.println("TRANSFER UUID::"+TransferUUID);

        if ((getSecondSnapshaot() == null ) || (getFirstSnapshot()==null))
            return;
        System.out.println("FIRST SNAPSHOT SIZE::"+getFirstSnapshot().length);
        System.out.println("SECOND SNAPSHOT SIZE::"+getSecondSnapshaot().length);

    }
    
    public String TotalSumm(){
        int withoutPercentage = this.getNetto()-this.getTrash();
        float result = withoutPercentage - (percentageOf(withoutPercentage, this.getSor()));
        BigDecimal bd = new BigDecimal(result*pricePerKg);
        bd = bd.setScale(2, BigDecimal.ROUND_HALF_UP);
        return String.valueOf(bd);
    };

    private int getDep(String department) {
            int dep;
            switch (department) {
                case "Кутум":
                    dep = 2;
                    break;
                case "Бабаевского":
                    dep = 24;
                    break;
                case "АЦКК":
                    dep = 1;
                    break;
                default:
                    dep = -1;
            }
            return dep;
    }

}
