package ch.hslu.ad.exercise.search;


public enum ANANASSearchState {
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
    };

    public abstract ANANASSearchState next(char n);
}