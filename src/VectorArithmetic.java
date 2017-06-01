/**
 * Created by oshriamir on 6/1/17.
 */
public class VectorArithmetic {

    /**
     * return the inner product of Vector _X_ and Vector _Y_ where : dot(_X_,_Y_) := sum(x_i*y_i) [0<=i<=2];
     *
     * @param _X_ - Vector at R^3;
     * @param _Y_ - Vector at R^3;
     * @return real number at R;
     */
    public static double dot(Vector _X_, Vector _Y_) {
        if (_X_.getLength() != _Y_.getLength())
            throw new IllegalArgumentException("dimensions disagree");

        double sum = 0.0;
        int len = _X_.getLength();

        for (int i = 0; i < len; i++)
            sum = sum + (_X_.getData()[i] * _Y_.getData()[i]);
        return sum;
    }

    //TODO: find the correct method who itai developed and copy here!!!

    /**
    public static Vector fixedUpDirection(Vector towards){
        double[] vectorData = towards.data;
        int coordinate = -1;
        for(int i=0; i<3; i++){
            if(vectorData[i] == 0){
                coordinate = i;
                break;
            }
        }
        Vector upDirection = null;
        switch (coordinate){
            case -1:
                upDirection = new Vector(1,1, -(towards.data[0]+ towards.data[1])/towards.data[2]);
                break;
            case 0:
                upDirection = new Vector(1,0, 0);
                break;
            case 1:
                upDirection = new Vector(0,1, 0);
                break;
            case 2:
                upDirection = new Vector(0,0, 1);
                break;
        }
        return upDirection;

    }
     **/


    /**
     * this method return the cross products of Vector _X_ and Vector _Y_,
     * where : cross(_X_,_Y_) := _Z_ s.t. :
     *          _Z_[0] = _X_.getData()[1] * _Y_.getData()[2] - _Y_.getData()[1] *  _X_.getData()[2];
     *          _Z_[1] = _X_.getData()[2] * _Y_.getData()[0] - _Y_.getData()[2] *  _X_.getData()[0];
     *          _Z_[2] = _X_.getData()[0] * _Y_.getData()[1] - _Y_.getData()[0] *  _X_.getData()[1];
     *
     * @param _X_ - Vector at R^3;
     * @param _Y_ - Vector at R^3;
     * @return Vector _Z_ at R^3;
     */
    // return the cross product of this Vector a and b
    public static  Vector cross(Vector _X_, Vector _Y_) {
        if (_X_.getLength() != _Y_.getLength()) {
            throw new IllegalArgumentException("dimensions disagree");
        }

        int len = _X_.getLength();
        double[] vecData = new double[len];

        vecData[0] = _X_.getData()[1] * _Y_.getData()[2] - _Y_.getData()[1] *  _X_.getData()[2];
        vecData[1] = _X_.getData()[2] * _Y_.getData()[0] - _Y_.getData()[2] *  _X_.getData()[0];
        vecData[2] = _X_.getData()[0] * _Y_.getData()[1] - _Y_.getData()[0] *  _X_.getData()[1];

        return new Vector(vecData);
    }


    /**
     * this method return the Euclidean norm of Vector _X_;
     * @param _X_ - Vector at R^3;
     * @return real number at R - the Euclidean norm of _X_;
     */
    public static double norm(Vector _X_) {
        return Math.sqrt(dot(_X_,_X_));
    }

    /**
     * return the Euclidean distance between Vector _X_ and Vector _Y_;
     * @param _X_ - Vector at R^3;
     * @param _Y_ - Vector at R^3;
     * @return real number at R - the Euclidean distance between Vector _X_ and Vector _Y_;
     */
    public static double distanceTo(Vector _X_, Vector _Y_) {
        if (_X_.getLength() != _Y_.getLength())
            throw new IllegalArgumentException("dimensions disagree");
        return norm(minus(_X_,_Y_));
    }

    /**
     * this method gets as a parameters Vector _X_ and Vector _Y_ and plus them.
     *
     * @param _X_
     * @param _Y_
     * @return
     */
    public static Vector plus(Vector _X_, Vector _Y_) {
        if (_X_.getLength() != _Y_.getLength())
            throw new IllegalArgumentException("dimensions disagree");

        int len = _X_.getLength();
        Vector _Z_ = new Vector(len);

        for (int i = 0; i < len; i++)
            _Z_.getData()[i] = _X_.getData()[i] + _Y_.getData()[i];
        return _Z_;
    }

    /**
     * this method gets as a parameters Vector _X_ and Vector _Y_ and sub them.
     *
     * @param _X_
     * @param _Y_
     * @return
     */
    public static Vector minus(Vector _X_, Vector _Y_) {
        if (_X_.getLength() != _Y_.getLength())
            throw new IllegalArgumentException("dimensions disagree");

        int len = _X_.getLength();
        Vector _Z_ = new Vector(len);

        for (int i = 0; i < len; i++)
            _Z_.getData()[i] = _X_.getData()[i] - _Y_.getData()[i];
        return _Z_;
    }

    // create and return a new object whose value is (this * factor)
    public static Vector scalarMultiplication(Vector _X_, double scalar) {

        int len = _X_.getLength();
        Vector _Z_ = new Vector(len);

        for (int i = 0; i < len; i++)
            _Z_.getData()[i] = scalar * _X_.getData()[i];
        return _Z_;
    }


    /**
     * this method return the Normelize of Vector _X_;
     *
     * @param _X_
     * @return Vector _*X*_ := _X_/(Norm(_X_);
     */
    public static Vector Normalize(Vector _X_) {
        if (norm(_X_) == 0.0)
            throw new ArithmeticException("zero-vector has no direction");
        return scalarMultiplication(_X_, 1.0 / norm(_X_));
    }
}
