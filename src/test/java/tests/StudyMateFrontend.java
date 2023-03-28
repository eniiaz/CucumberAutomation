package tests;

public class StudyMateFrontend {

    public static void main(String[] args) {

        StudyMate codewise = new StudyMate();
        System.out.println(codewise.getGroups());
        codewise.createGroup("Batch 1");
        codewise.createGroup("Batch 2");
        codewise.createGroup("English Online");
        System.out.println(codewise.getGroups());
        codewise.updateGroup("Batch 2 Offline", "Batch 2");
        System.out.println(codewise.getGroups());

    }

}
