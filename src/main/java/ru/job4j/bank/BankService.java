package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает работу банковского сервиса, который добавляет пользователя,
 * добавляет аккаунт пользователю (аккаунтов у пользователя может быть несколько),
 * находит пользователя по паспортным данным, находит аккаунт пользователя по
 * по паспортным данным и реквизитам, осуществляет денежные переводы,
 * удаляет пользователя
 * @author KONSTANTIN DOLGOV
 * @version 1.0
 */
public class BankService {
    /**
     * Хранение пользователей и их аккаунтов осуществляется в коллекции типа Map
     */
    private final Map<User, List<Account>> users = new HashMap<>();

    /**
     * Метод принимает на вход пользователя и, если такого пользователя нет,
     * добавляет его в коллекцию, создавая ему аккаунт
     * @param user пользователь, который добавляется в коллекцию
     */
    public void addUser(User user) {
        users.putIfAbsent(user, new ArrayList<Account>());
    }

    /**
     * Метод принимает на вход паспортные данные палзователя и аккаунт, и
     * если такой пользователь существует (существование пользователя проверяется
     * поиском по паспортным данным методом findByPassport), то добавляет этому
     * пользователю аккаунт, проверяя что такого аккаунта у него нет
     * @param passport паспортные данные пользователя, по которым находим пользователя
     * @param account аккаунт, который добавляем пользователю
     */
    public void addAccount(String passport, Account account) {
        User user = findByPassport(passport);
        if (user != null) {
            List<Account> accounts = users.get(user);
            if (!accounts.contains(account)) {
                accounts.add(account);
            }
        }
    }

    /**
     * Метод принимает на вход паспортные данные палзователя,
     * если такой пользователь с таким паспортными данными существует
     * находит его, если такого нет возвращает null
     * @param passport паспортные данные палзователя
     * @return возвращает пользователя у которого такие паспортные
     * данные или если такого нет возвращает null
     */
    public User findByPassport(String passport) {
        return users.keySet()
                .stream()
                .filter(s -> passport.equals(s.getPassport()))
                .findFirst()
                .orElse(null);
    }

    /**
     * Метод принимает на вход паспортные данные пользователя и
     * реквизиты аккаунта. В начале находит пользователя по паспортым
     * данным и если такой существует находит аккаунт по реквизитам если
     * такой усть у пользователя
     * @param passport паспортные данные пользователя
     * @param requisite реквизиты аккаунта пользователя
     * @return возвращает аккаунт пользователя, если пользователя или
     * аккаунта не существует возвращает null
     */
    public Account findByRequisite(String passport, String requisite) {
        User user = findByPassport(passport);
        if (user != null) {
            return users.get(user)
                    .stream()
                    .filter(s -> requisite.equals(s.getRequisite()))
                    .findFirst()
                    .orElse(null);
        }
        return null;
    }

    /**
     * Метод принимает на вход паспортные данные пользователя, от которого
     * переводят деньги, реквизиты аккаунта с которого переводят деньги,
     * паспортные данные пользователя, которому переводят деньги,
     * реквизиты аккаунта на который переводят деньги, сумму переводимых денег.
     * Находит с помощью метода findByRequisite аккаунты пользователей с которого
     * переводят деньги и на который перводят деньги, если такие аккаунты существуют
     * и балланс денег позволяет сделать перевод, то перводит заданную сумму денег
     * с одного на другой аккаунт.
     * @param srcPassport паспортные данные пользователя, от которого переводят деньги
     * @param srcRequisite реквизиты аккаунта с которого переводят деньги
     * @param destPassport паспортные данные пользователя, которому переводят деньги
     * @param destRequisite реквизиты аккаунта на который переводят деньги
     * @param amount сумма переводимых денег
     * @return возвращает подтверждение (true) если перевод денег выполнился,
     * если одно из условий не выполнено: не существует аккаунтов таких пользователей,
     * не достаточно денег на баллансе для перведа, то перевод не выпонится,
     * вернет false
     */
    public boolean transferMoney(String srcPassport, String srcRequisite,
                                 String destPassport, String destRequisite, double amount) {
        boolean rsl = false;
        Account srcAccount = findByRequisite(srcPassport, srcRequisite);
        Account destAccount = findByRequisite(destPassport, destRequisite);
        if (srcAccount != null && destAccount != null
                && srcAccount.getBalance() >= amount) {
            destAccount.setBalance(destAccount.getBalance() + amount);
            srcAccount.setBalance(srcAccount.getBalance() - amount);
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод принимает на вход паспортные данные пользователя
     * и удаляет такого пользователя из коллекции
     * @param passport паспортные данные пользователя
     */
    public void deleteUser(String passport) {
        users.remove(new User(passport, null));
    }

    /**
     * Вспомогательный метод для тестов, принимает на вход
     * пользователя и возвращет такого пользаветеля
     * из коллекции
     * @param user пользователь
     * @return возвращет пользаветеля из коллекции
     */
    public List<Account> getAccounts(User user) {
        return users.get(user);
    }
}
