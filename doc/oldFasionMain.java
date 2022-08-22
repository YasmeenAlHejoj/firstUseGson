public class oldFasionMain {
    public static void main(String[] args) {
        /*  Gson gson = instance.getGson();
        writeToFile(gson);
        readFile(gson);*/
    }
    public static void readFile(Gson gson) {
        try {
            FileReader fileReader = new FileReader("account.json");
            Account account = gson.fromJson(fileReader, Account.class);
            System.out.println(account);
        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }

    public static void writeToFile(Gson gson) {
        Account account = new Account("1", "acc1", LocalDateTime.now());
        try {
            Writer writer = new FileWriter("account.json");
            gson.toJson(account, writer);
            // close the writer
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}