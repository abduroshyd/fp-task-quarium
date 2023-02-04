package dev.abduroshyd.constants;

//created by @abduroshyd 03/02/23
public interface Messages {

    String warning = "\033[33m" + "Faqatgina buyruq raqamlarini kirita olasiz!" + "\033[0m";
    String meetingInfo = "\033[32m" + "Baliq tartib raqamini kiriting. Masalan:" + "\033[0m" + " " + "\033[34m" + "1+2" +  "\033[0m" + ": ";
    String selectCommand = "\033[34m" + "Quyidagilardan⬆️ birini tanlang: " + "\033[0m";
    String greetings = "Assalomu alaykum";
    String successFullySaved =  "\033[32m" + "Muvoffaqiyatli saqlandi!" + "\033[0m";
    String noMoreFishLeft = "Akvariumda baliqlar tugab qoldi - !!!";
    String noMoreFishLeftForMeeting = " Baliqlar uchrashishi kerak edi ammo akvariumda 1 tagina baliq qolgan";
    String genderIsNotEqual = "Baliqlar uchrashib qolishdi ammo baliq jisnlari bir-biriga mos emas!";
    String fishAlreadyDied = "Baliqlardan biri akvariumda maavjud emas!";
    String outOfCapacity = "Akvarium to'ldi va ishdan chiqdi";
}
