package ch.hslu.ad.exercise.search;


interface SearchState {
    public abstract SearchState next(char n);
    public default boolean found() {
        return false;
    }
}

public enum ANANASSearchState implements SearchState {
    Start {
        @Override
        public ANANASSearchState next(char n) {
            if (n == 'A') {
                return ANANASSearchState.Z1;
            } else {
                return Start;
            }
        }
    },
    Z1 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'N') {
                return Z2;
            } else {
                return Start;
            }
		}
    },
    Z2 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'A') {
                return Z3;
            } else {
                return Start;
            }
		}
    },
    Z3 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'N') {
                return Z4;
            } else {
                return Start;
            }
		}
    },
    Z4 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'A') {
                return Z5;
            } else {
                return Start;
            }
		}
    },
    Z5 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'S') {
                return End;
            } else {
                return Z4;
            }
		}
    },
    End {
		@Override
		public ANANASSearchState next(char n) {
			return Start;
        }
        @Override
        public boolean found() {
            return true;
        }
    };
}