package com.chekvend.test;

import android.test.AndroidTestCase;

import com.chekvend.Constants;
import com.chekvend.Model.Coin;
import com.chekvend.Machine;
import com.chekvend.Model.Product;

import java.util.ArrayList;


public class MachineTest extends AndroidTestCase {

    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }

    public void testMachineTakesOnlyValidCoins() {
        Machine machine = new Machine();

        assertEquals(Constants.INVALID_COIN, machine.insertCoin(new Coin(Constants.PENNY)));
        assertEquals(0.05, machine.insertCoin(new Coin(Constants.NICKEL)));
    }

    public void testMachineComputesCorrectTotalInserted() {
        Machine machine = new Machine();
        ArrayList<Coin> coinList = new ArrayList<>();

        coinList.add(new Coin(Constants.QUARTER));
        coinList.add(new Coin(Constants.NICKEL));
        coinList.add(new Coin(Constants.DIME));
        coinList.add(new Coin(Constants.QUARTER));

        for (Coin coin : coinList)
            machine.insertCoin(coin);

        assertEquals(0.65, machine.getTotalInserted());
    }

    public void testMachinePutCorrectInvalidChangeInReturn() {
        Machine machine = new Machine();
        ArrayList<Coin> coinList = new ArrayList<>();

        coinList.add(new Coin(Constants.GOLDEN_DOLLAR));
        coinList.add(new Coin(Constants.PENNY));

        for (Coin coin : coinList)
            machine.insertCoin(coin);

        assertEquals(1.01, machine.getTotalReturning());
    }

    public void testMachineDeductCorrectTotalOnPurchase() {
        Machine machine = new Machine();
        ArrayList<Coin> coinList = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            coinList.add(new Coin(Constants.QUARTER));

        for (Coin coin : coinList)
            machine.insertCoin(coin);

        machine.purchase(new Product(Constants.COLA));

        assertEquals(0.0, machine.getTotalInserted());
    }

    public void testNotEnoughChangeInsertedToPurchaseProduct() {
        Machine machine = new Machine();
        machine.insertCoin(new Coin(Constants.QUARTER));
        assertFalse(machine.haveEnoughToPurchase(new Product(Constants.CHIPS)));
    }

    public void testIfUserWillRecieveChange() {
        Machine machine = new Machine();
        ArrayList<Coin> coinList = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            coinList.add(new Coin(Constants.QUARTER));

        for (Coin coin : coinList)
            machine.insertCoin(coin);

        assertTrue(machine.willNeedChange(new Product(Constants.CHIPS)));
    }

    public void testChangeNeededToPurchaseProductWhenNotEnoughInserted() {
        Machine machine = new Machine();
        machine.insertCoin(new Coin(Constants.QUARTER));
        assertEquals(0.25, machine.changeNeeded(new Product(Constants.CHIPS)));
    }

    public void testCollectChangeReturnsCorrectAmount() {
        Machine machine = new Machine();
        machine.insertCoin(new Coin(Constants.GOLDEN_DOLLAR));
        assertEquals(1.0, machine.collectChange());
    }

    public void testCoinReturnsEmptiesOnCollectChange() {
        Machine machine = new Machine();
        machine.insertCoin(new Coin(Constants.GOLDEN_DOLLAR));
        machine.collectChange();
        assertEquals(0.0, machine.getTotalReturning());
    }

    public void testDecrementChipsInventory() {
        Machine machine = new Machine();
        int chips = machine.getChips();
        machine.takeProduct(new Product(Constants.CHIPS));
        assertEquals(chips - 1, machine.getChips());
    }

    public void testDecrementColaInventory() {
        Machine machine = new Machine();
        int colas = machine.getColas();
        machine.takeProduct(new Product(Constants.COLA));
        assertEquals(colas - 1, machine.getColas());
    }

    public void testDecrementCandyInventory() {
        Machine machine = new Machine();
        int candies = machine.getCandies();
        machine.takeProduct(new Product(Constants.CANDY));
        assertEquals(candies - 1, machine.getCandies());
    }

    public void testOutOfStock() {
        Machine machine = new Machine();
        ArrayList<Coin> coinList = new ArrayList<>();
        for (int i = 0; i < 4; i++)
            coinList.add(new Coin(Constants.QUARTER));

        for (Coin coin : coinList)
            machine.insertCoin(coin);

        machine.setChips(0);
        assertFalse(machine.purchase(new Product(Constants.CHIPS)));
    }

    public void testReturnAllCoinsReturnsCorrectAmount() {
        Machine machine = new Machine();
        machine.setTotalReturning(6.0);
        machine.setTotalInserted(0.5);
        assertEquals(6.5, machine.returnAllCoins());
    }

    public void testReturnAllCoinsResetsCoinValuesInMachine() {
        Machine machine = new Machine();
        machine.setTotalReturning(6.0);
        machine.setTotalInserted(0.5);
        machine.returnAllCoins();
        assertEquals(0.0, machine.getTotalReturning());
        assertEquals(0.0, machine.getTotalInserted());
    }

}
