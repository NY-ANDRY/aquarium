/**
 * @param {import('react').ButtonHTMLAttributes<HTMLButtonElement>} props
 */
const Button = ({ children, className = '', ...props }) => {
    return (
        <button
            {...props}
            className={`font-poppins-b text-cyan-8s00 cursor-pointer ${className}`}
        >
            {children}
        </button>
    );
};

export default Button;
