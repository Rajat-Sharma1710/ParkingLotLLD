
---------------------------------IMPROVED SOLUTION--------------------------------------
Taking care of violation of SRP, OCP, ISP, DIP
Taking care of certain design patterns to use like strategy
Open for extensibility of different features in near future like -
    1. Diff types of vehicle introduced like bike, electric motors etc
    2. Introduce payments for parking
    3. Introduce floors of parking
    and a lot more....

🔹 Step 1 — Requirements Clarification

    Single floor?
    Fixed size n?
    Only cars?
    Commands needed?

🔹 Step 2 — Identify Core Entities

    Vehicle
    Slot
    Ticket
    ParkingLot

🔹 Step 3 — Identify Core Operations

    park
    leave
    get slots by colour
    get reg numbers by colour
    get slot by reg number

🔹 Step 4 — Choose Data Structures

    Min-heap for nearest empty slot
    HashMap for reg → slot
    HashMap for color → list of slots
🔹 Step 5 — Ensure SOLID

    SRP → separate classes
    OCP → strategy pattern for allocation
    LSP → vehicle polymorphism
    ISP → separate interface
    DIP → service depends on abstraction, not implementation

                        +-----------------------+
                        |      Vehicle (interface) |
                        +-----------------------+
                        | + getRegistrationNumber()|
                        | + getColor()             |
                        +-------------▲-----------+
                                      |
                                      |
                            +---------+---------+
                            |       Car         |
                            +-------------------+
                            | - registrationNumber: String (final)
                            | - color: String (final)
                            +-------------------+
                            | + getters...       |
                            +-------------------+

+------------------+        1         1        +----------------------+
|       Slot       |-------------------------->|       Vehicle        |
+------------------+                           +----------------------+
| - slotNumber: int|
| - vehicle: Vehicle? |
+------------------+
| + isOccupied()   |
| + assignVehicle()|
| + removeVehicle()|
+------------------+

                     +--------------------------+
                     |         Ticket           |
                     +--------------------------+
                     | - ticketId: String       |
                     | - slotNumber: int        |
                     | - vehicle: Vehicle       |
                     | - issuedAt: DateTime     |
                     +--------------------------+
                     | + getters...             |
                     +--------------------------+


          +-----------------------------------------------+
          |        SlotAllocationStrategy (interface)     |
          +-----------------------------------------------+
          | + getNextAvailableSlot(): int                 |
          | + markSlotFree(slot: int): void               |
          +--------------------------▲--------------------+
                                     |
                                     |
                     +---------------+-------------------+
                     |         NearestSlotStrategy       |
                     +-----------------------------------+
                     | - freeSlots: MinHeap<Integer>     |
                     +-----------------------------------+
                     | + implementation...               |
                     +-----------------------------------+


                    +-------------------------------------+
                    |     ParkingLot (interface)          |
                    +-------------------------------------+
                    | + park(vehicle): Ticket             |
                    | + leave(slotNumber): void           |
                    | + getSlotsByColor(color): List<Int> |
                    | + getRegsByColor(color): List<Str>  |
                    | + getSlotByReg(reg): Integer        |
                    +------------------▲------------------+
                                       |
                                       |
                        +--------------+----------------------+
                        |        ParkingLotService            |
                        +-------------------------------------+
                        | - Map<Integer, Slot> occupiedSlots  |
                        | - Map<String, List<Integer>> colorToSlots |
                        | - Map<String, Integer> regToSlot    |
                        | - SlotAllocationStrategy strategy   |
                        +-------------------------------------+
                        | + actual service methods...         |
                        +-------------------------------------+
