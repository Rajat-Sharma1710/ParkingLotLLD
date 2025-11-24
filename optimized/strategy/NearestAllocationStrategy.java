package problems.parkingLot.optimized.strategy;

import problems.parkingLot.optimized.model.Slot;

import java.util.PriorityQueue;

public class NearestAllocationStrategy implements SlotAllocationStrategy{
    private PriorityQueue<Integer> pq;

    public NearestAllocationStrategy(int capacity) {
        pq = new PriorityQueue<>();
        for(int i = 1; i <= capacity; i++) {
            pq.add(i);
        }
    }

    @Override
    public int getNearestAvailableSlot() {
        if(!pq.isEmpty()) {
            return pq.poll();
        } else {
            return -1;
        }
    }
}
