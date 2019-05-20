package ch.hslu.ad.exercise.search;


public enum ANANASSearchState {
    Z0 {
        @Override
        public ANANASSearchState next(char n) {
            if (n == 'A') {
                return ANANASSearchState.Z1;
            } else {
                return Z0;
            }
        }
    },
    Z1 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'N') {
                return Z2;
            } else {
                return Z0;
            }
		}
    },
    Z2 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'A') {
                return Z3;
            } else {
                return Z0;
            }
		}
    },
    Z3 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'N') {
                return Z4;
            } else {
                return Z0;
            }
		}
    },
    Z4 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'A') {
                return Z5;
            } else {
                return Z0;
            }
		}
    },
    Z5 {
		@Override
		public ANANASSearchState next(char n) {
			if (n == 'S') {
                return Z6;
            } else {
                return Z0;
            }
		}
    },
    Z6 {
		@Override
		public ANANASSearchState next(char n) {
			return Z0;
		}
    };

    public abstract ANANASSearchState next(char n);
}