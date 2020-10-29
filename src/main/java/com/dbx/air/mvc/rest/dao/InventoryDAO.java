package com.dbx.air.mvc.rest.dao;

import com.dbx.air.mvc.rest.entity.InventoryState;
import com.dbx.air.mvc.rest.entity.Invetory;
import org.springframework.stereotype.Repository;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.math.RoundingMode;
import java.util.*;
import java.lang.*;
import java.util.stream.Collectors;

@Repository
public class InventoryDAO implements InventoryDAOInterface {
    private static ArrayList<Invetory> inventories = new ArrayList<>();
    private static final ArrayList<String> brand = new ArrayList();
    private static final ArrayList<String> type = new ArrayList();
    private static final ArrayList<String> description = new ArrayList();

    static {
        brand.add("samsung");
        brand.add("lg");
        brand.add("singer");
        brand.add("philips");

        type.add("tv");
        type.add("refrigerator");
        type.add("radio");
        type.add("laptop");

        description.add("32\" hd-led tv (e5108) 3year warranty");
        description.add("43\" INCH HD LED TV WITH 3 YEARS WARRANTY");
        description.add("40\" Full HD Ultra Slim LED TV-40PFT5063");
        description.add("22\" Full HD LED TV / Monitor 22PFT5403");

        description.add("180L Double Door Direct Cool Refrigerator");
        description.add("Fridge 250L inverter no frost Double door with 10 Years Damro Warranty");
        description.add("Double Door Refrigerator 250L invertor -10 years damro warranty");
        description.add("Double Door Refrigerator 250L invertor");

        description.add("Original Earth Star 3 Band Rechargeable Radio with USB/TF Slot ES-101U - Radio Sound System");
        description.add("Astro Rechargable Mini Radio USB Bluetooth Support");
        description.add("Astro Mini Radio USB Bluetooth Support");
        description.add("Analog Radio Den-b KS 888 Portable AC & DC");

        description.add("15.6 Inch FHD ( 10th Gen Core i3 ) 4GB DDR4 1TB HDD");
        description.add("X360 14 Inches FHD Display ( 10th Gen Core i5 ) 8GB DDR4 256GB SSD");
        description.add("17.3 FHD Intel Core I5 9th Gen GTX 1650 Win10 Gaming Laptop");
        description.add("Aspire 5 A515 ( INTEL CORE I5 10TH GEN 8GB DDR4 RAM 15.6'' FHD IPS 1TB HDD BACKLIT KEYBOARD WINDOWS 10 HOME 3 YEARS LIMITED)");

        int a = 100;
        Random r = new Random();

        for(int i=0; i<4 ; i++) {
            for(int j=0; j<4 ; j++) {
                for(int k=0; k<4 ; k++) {
                    int v = 0;
                    if(j==0) v = k;
                    if(j==1) v = k + 4;
                    if(j==2) v = k + 8;
                    if(j==3) v = k + 12;

                    int p = r.nextInt((50000 - 10000) + 1) + 10000;
                    int pp = r.nextInt((90 - 20) + 1) + 20;

                    String price = p + "." + pp;

                    int dddd = r.nextInt((2030 - 2022) + 1) + 2022;
                    int dd = r.nextInt((12 - 1) + 1) + 1;
                    int d = r.nextInt((28 - 1) + 1) + 1;
                    String date = dddd + "-" + dd + "-"+ d;

                    inventories.add(new Invetory(a++,brand.get(i),type.get(j),description.get(v),price,date));
                }
            }
        }

//        inventories.forEach(v -> {
//            System.out.println(v.getBrand()+" "+ v.getType()+" "+ v.getDescription()+" "+  v.getPrice()+" "+ v.getExpire());
//        });
    }

    @Override
    public List<Invetory> getInventories(HashMap<String, List<String>> allMap) throws Exception{

        List<Invetory> filterList =  inventories.stream()
                .filter(v -> {
//                    find Brand
                    if(allMap.get("brandCtrl").get(0).equals("any")){
                        return true;
                    }
                    return allMap.get("brandCtrl").stream().map((m) -> {
//                        System.out.println(v.getId()+ " req brand "+ m + " " + "item brand " + v.getBrand() +" "+ m.equals(v.getBrand()));
                        return m.equals(v.getBrand());
                    }).reduce(false,
                            (a, b) -> {return a | b;});
                })
                .filter(v -> {
//                    find Type
                    if(allMap.get("typeCtrl").get(0).equals("any")){
                        return true;
                    }
                    return allMap.get("typeCtrl").stream().map((m) -> {
//                        System.out.println(v.getId()+ " req brand "+ m + " " + "item brand " + v.getType() +" "+ m.equals(v.getType()));
                        return m.equals(v.getType());
                    }).reduce(false,
                            (a, b) -> {return a | b;});
                })
                .filter(v -> {
//                    find text
                    if(allMap.get("textCtrl").get(0).equals("any")) {
                        return true;
                    }
                    return allMap.get("textCtrl").stream().map((m) -> {
                        return Arrays.stream(v.getDescription().trim().toLowerCase().split(" "))
                                .filter((vv) -> vv !=" ")
                                .map((mm) -> mm.indexOf(m) != -1 )
                                .reduce(false, (aa, bb) -> aa | bb);
                    }).reduce(false,
                            (a, b) -> {return a | b;});
                })
                .collect(Collectors.toList());
//        filterList.forEach((v)-> System.out.println(v.getBrand()+" "+ v.getType()+ " "+ v.getDescription()));
        return filterList;
    }
    @Override
    public InventoryState deleteInventory(Integer id)  throws Exception{

        Invetory isFind = inventories.stream()
                .filter((v) -> v.getId() == id)
                .findFirst()
                .orElse(null);
        if(isFind == null) {
            return InventoryState.NOTFOUND;
        }
        inventories = (ArrayList<Invetory>) inventories.stream().filter((v) -> {
           return v.getId() != id;
        }).collect(Collectors.toList());
        return InventoryState.DELETED;
    }

    @Override
    public InventoryState updateInventory(Integer id, Invetory item) throws Exception {
        item.setPrice(new BigDecimal(item.getPrice()).setScale(2, RoundingMode.FLOOR).toString());
        Invetory isFind =inventories.stream().filter(v -> v.getId() == id).findFirst().orElse(null);
        if(isFind == null) {
            return InventoryState.NOTFOUND;
        }
        inventories = (ArrayList<Invetory>) inventories.stream().map(v -> {
            if(v.getId() == id){
                return item;
            }else {
                return v;
            }
        }).collect(Collectors.toList());
        return InventoryState.UPDATED;
    }

    @Override
    public InventoryState addInventory(Invetory item) throws Exception {

        item.setPrice(new BigDecimal(item.getPrice()).setScale(2, RoundingMode.FLOOR).toString());
        int size = inventories.size();
        if(size > 0) {
            item.setId(inventories.get(size - 1).getId() + 1);
        }else {
            item.setId(100);
        }
        inventories.add(item);

        return InventoryState.ADDED;
    }
}
